package de.mosaic4cap.webapp.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Checks actual disc space situation
 * if theres enough space builder.up is called else its down
 * <p/>
 * Created by Lobedan on 03.09.2014.
 */
@Component
public class DiskSpaceHealthIndicator extends AbstractHealthIndicator {

    private final FileStore fileStore;
    private final long thresholdBytes;

    @Autowired
    public DiskSpaceHealthIndicator(@Value("${health.filestore.path:${user.dir}}") String path,
                                    @Value("${health.filestore.threshold.bytes:10485760}") long aThresholdBytes) throws IOException {
        fileStore = Files.getFileStore(Paths.get(path));
        this.thresholdBytes = aThresholdBytes;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        long diskFreeInBytes = fileStore.getUnallocatedSpace();
        if (diskFreeInBytes >= thresholdBytes) {
            builder.up();
        } else {
            builder.down();
        }
        long totalSpaceInBytes = fileStore.getTotalSpace();
        builder.withDetail("disk.free", diskFreeInBytes);
        builder.withDetail("disk.total", totalSpaceInBytes);
    }
}
