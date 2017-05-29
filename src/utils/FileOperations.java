package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.management.*;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class FileOperations {
	
    public static void createStatisiticsHeaderFile() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t");
        
        Long memorySize = ((com.sun.management.OperatingSystemMXBean) 
                ManagementFactory.getOperatingSystemMXBean()
                ).getTotalPhysicalMemorySize();
        int nCores = Runtime.getRuntime().availableProcessors();        
        float ram = memorySize / 1000000000; //GB

        String cpuName = System.getenv("PROCESSOR_IDENTIFIER");
        try {
            cpuName = getCPUName();
        } catch (SigarException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        
        sb.append(cpuName+", "+nCores+" Core(s), "+ram+" GB RAM");
        sb.append("\n\t");
        
        String osName= System.getProperty("os.name");
        String osType= System.getProperty("os.arch");
        sb.append(osName+" "+osType);
        sb.append("\n\t");
        
        String javaApi = System.getProperty("java.specification.name");
        String javaVersion= System.getProperty("java.specification.version");
        sb.append(javaApi+" "+javaVersion);
        sb.append("\n\n");
        
        sb.append("Algorithm" + "\t");
        sb.append("Solution Cost" + "\t");
        sb.append("Num of Expanded Nodes" + "\t");
        sb.append("Max Frontier Size" + "\t");
        sb.append("Num of generated nodes" + "\t");
        sb.append("Time of Execution (Millis)" + "\t");
        sb.append("Heuristic" + "\t");
        sb.append("Limit/Beam Size" + "\n");
        
        appendToTextFile("Statistics.xls", sb.toString());
    }
    
    /**
     * Appends a string to a text file.
     * @param fileName text file name.
     * @param string string to be appended.
     */
    public static void appendToTextFile(String fileName, String string){
        BufferedWriter w = null;
        try {
            w = new BufferedWriter(new FileWriter(fileName, true));
            w.write(string);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            try {
                if (w != null){
                    w.close();
                }
            } catch (IOException ignore) {
            }
        }
    }
    
    public static boolean fileExist(String fileName){
        File f = new File(fileName);
        return f.exists() && !f.isDirectory();
    }
    
    public static String getCPUName() throws SigarException {
        Sigar sigar = new Sigar();
        org.hyperic.sigar.CpuInfo[] cpuInfoList = sigar.getCpuInfoList();
        return cpuInfoList[0].getModel();
    }
    
    public static void saveImage(String fileName, BufferedImage renderedImage){
        // Find a jpeg writer
        ImageWriter writer = null;
        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
        if (iter.hasNext()) {
            writer = (ImageWriter) iter.next();
        }

        //Defining compression level
        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(1);

        try {
            // Prepare output file
            File outFile = new File(fileName);
            FileImageOutputStream output = new FileImageOutputStream(outFile);

            //write the image
            writer.setOutput(output);
            IIOImage imageIIO = new IIOImage(renderedImage, null, null);
            writer.write(null, imageIIO, iwp);

        } catch (IOException ex) {
        }        
    }
}
