package de.enginkarakurt.microbotlauncherunix.util;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class FileUtil {

    public static void setupDirectory() {
        if (new File("jars").mkdirs()) {
            System.out.println("--- Setup directory ---");
            System.out.println("Creating jars folder...");
        }
    }

    public static String updateAndRetrieveLatestVersion() {
        JSONObject assetToDownload = VersionUtil.getAssetToDownload();

        if(assetToDownload == null && getFilesFromJarsDir().length > 0) {
            return getFilesFromJarsDir()[0].getName();
        }

        if(VersionUtil.checkVersion() > 1 || getFilesFromJarsDir().length < 1) {
                System.out.println("Download new release...");

                try {
                    URL url = new URI(Objects.requireNonNull(assetToDownload).get("browser_download_url").toString()).toURL();

                    InputStream inputStream = url.openStream();
                    FileOutputStream fileOutputStream = new FileOutputStream("jars/" + assetToDownload.get("name").toString());

                    byte[] bytes = new byte[1024];
                    int len;

                    while ((len = inputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }

                    fileOutputStream.close();
                    inputStream.close();

                    System.out.println("Download completed!");

                    return assetToDownload.get("name").toString();
                } catch (Exception ex) {
                    System.out.println("Download Failed! ");
                }
        } else {
            System.out.println("You are up-to-date!");
        }

        return Objects.requireNonNull(new File(System.getProperty("user.dir") + "/jars/" + Objects.requireNonNull(assetToDownload).get("name").toString()).getName());
    }

    public static void runJarFile(String fileName) {
        System.out.println("--- Execute the .jar ---");
        System.out.printf("Attempting to run %s...%n", fileName);
        try {
            Runtime.getRuntime().exec(
                    String.format("java -jar %s", fileName),
                    null,
                    new File(System.getProperty("user.dir") + "/jars")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File[] getFilesFromJarsDir() {
        return new File(System.getProperty("user.dir") + "/jars").listFiles();
    }
}
