#!/bin/bash 

#
# This script can be used to run the GIPS MWE.
#
# @author Maximilian Kratz (maximilian.kratz@es.tu-darmstadt.de)
#

# set -e

function setup {
    # Make sure that log folders exists
    mkdir -p $outputFolder

    # Extract needed XMI files
    echo "# Script info: Applying GIPS XMI workarounds."

    # Extract XMI files
    unzip -qq -o $JAR "audiologyoptimiser/hipe/*/hipe-network.xmi"
    unzip -qq -o $JAR "audiologyoptimiser/api/*/gips-model.xmi"
    unzip -qq -o $JAR "audiologyoptimiser/api/ibex-patterns.xmi"

    # Copy extracted files into bin for HiPE
    mkdir -p ./bin
    rm -rf ./bin/audiologyoptimiser
    cp -r ./audiologyoptimiser ./bin/
}

function run_experiment {
    # Execute the program itself and save its output to log file
    java \
        -Xms16g \
        -Xmx24g \
        -XX:+ExitOnOutOfMemoryError \
        -jar "$JAR" $ARGS

    # Move Gurobi's log file to the repetition's output folder
    mv Gurobi*.log $outputFolder

    # Move JDK's crash log file to output folder (if any)
    if [ $(ls hs_err_*.log 2>/dev/null | wc -l) -gt 0 ]; then
        mv hs_err_*.log $outputFolder
    fi
}

function cleanup {
    rm -r ./audiologyoptimiser
    rm -rf ./bin/audiologyoptimiser
}

function run_wrap_all {
    # Run setup
    setup

    # Actual run
    export ARGS="$inputModelPath $outputModelPath $numberOfRuns"

    echo "# Script info: Using ARGS: $ARGS"
    run_experiment
    # Finished actual run

    # Clean up extracted files
    cleanup

    echo "# => GIPS start script done."
}

# Set env vars
source env.sh

# Config
export JAR="gips-audiology-headless.jar"
export outputFolder="output"
mkdir -p $outputFolder

# Arguments: for this example, we use hard-coded arguments
export numberOfAppointments="${1:-100}"
export inputModelPath="../../audiologymodel/model/AudiologyBooking_${numberOfAppointments}.xmi"
export outputModelPath="./$outputFolder/optimized_model_${numberOfAppointments}.xmi"
export numberOfRuns="${2:-10}"

# Run wrapping function
export RUN_NAME=$(date +%Y-%m-%d"_"%H-%M-%S)
run_wrap_all 2>&1 | tee "./$outputFolder/$RUN_NAME.log"