package audiologymodel.importexport;

import audiologymodel.AudiologyBooking;
import audiologymodel.AudiologymodelPackage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.emoflon.smartemf.persistence.SmartEMFResourceFactoryImpl;

/** Saves AudiologyBooking models as SmartEMF-compatible XMI. */
public final class AudiologyModelIO {

    private AudiologyModelIO() {}

    public static void save(AudiologyBooking booking, Path outputXmi)
            throws IOException {

        Objects.requireNonNull(booking, "booking");
        Objects.requireNonNull(outputXmi, "outputXmi");
        AudiologymodelPackage.eINSTANCE.eClass();

        Path absoluteOutput = outputXmi.toAbsolutePath().normalize();
        if (absoluteOutput.getParent() != null) {
            Files.createDirectories(absoluteOutput.getParent());
        }

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(
                AudiologymodelPackage.eNS_URI,
                AudiologymodelPackage.eINSTANCE);
        resourceSet.getResourceFactoryRegistry()
                .getExtensionToFactoryMap()
                .put("xmi", new SmartEMFResourceFactoryImpl(null));

        Resource resource = resourceSet.createResource(
                URI.createFileURI(absoluteOutput.toString()));

        if (resource == null) {
            throw new IOException(
                    "Could not create XMI resource: " + absoluteOutput);
        }

        resource.getContents().add(booking);
        resource.save(Map.of(
                XMLResource.OPTION_ENCODING,
                StandardCharsets.UTF_8.name()));

        System.out.println("Saved model to: " + absoluteOutput);
    }
}