 
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Vector;
 
public class FTPUploadFileDemo{
 
//    private static final int BUFFER_SIZE = 4096;
// 
//    public static void main(String[] args) {
//        
//        String ftpUrl = "sftp://wissem%20ayadi/127.0.0.1";
//        String host = "127.0.0.1";
//        String user = "wissem ayadi";
//        String pass = "wissal84";
//        String filePath = "/Users/naderayadi/WISSEM AYADI.pdf";
//        String uploadPath = "/Users/Shared";
// 
//        ftpUrl = String.format(ftpUrl, user, pass, host, uploadPath);
//        System.out.println("Upload URL: " + ftpUrl);
// 
//        try {
//            URL url = new URL(ftpUrl);
//            URLConnection conn = url.openConnection();
//            OutputStream outputStream = conn.getOutputStream();
//            FileInputStream inputStream = new FileInputStream(filePath);
// 
//            byte[] buffer = new byte[BUFFER_SIZE];
//            int bytesRead = -1;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
// 
//            inputStream.close();
//            outputStream.close();
// 
//            System.out.println("File uploaded");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
    public static void main(String[] args) throws Exception{
        JSch jsch = new JSch();
        
        Session session = jsch.getSession("cmb", "localhost");
        session.setPassword("cmb123");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        
        ChannelSftp channelSftp = (ChannelSftp)session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.setFilenameEncoding("gbk");
        
        Vector vector  = channelSftp.ls("/");
        try{
            for(Object obj :vector){
                if(obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry){
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry)obj).getFilename();
                    System.out.println(fileName);
                }
            }
        }
        finally{
            channelSftp.quit();
            session.disconnect();
        }
    }

}