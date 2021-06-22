package utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class CustomReports {
	


    public static void updateReport(int index, String scriptName, String testCaseName, String testCaseStatus,//creating custom html report
            String description) throws IOException {

 
        String startDateTime = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
      
        String rfile = System.getProperty("user.dir")+"\\CustomHTMLReport\\htmlreport.html";
        File file = new File(rfile);

        if (!file.exists()) {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("<html>" + "\n");
            bw.write("<head><title>" + "Test Report" + "</title>" + "\n");
            bw.write("</head>" + "\n");
            bw.write("<body>");
            bw.write("<font face='Arial' size='2' " + "\n");
            bw.write("<u><h1><align='center'>" + "Test  Report" + "</h1></u>" + "\n");
            bw.flush();
            bw.close();


        }

 

        BufferedWriter bw1 = new BufferedWriter(new FileWriter(file, true));
        if (index == 1) {
            bw1.write("<table align='center' border='0' width='80%' height='20%'> ");
            bw1.write("<tr><td width='80%' </td></tr>");
            bw1.write("<table align='center' border='1' width='80%' height='57%'> ");
            bw1.write("<tr>");
            bw1.write(
                    "<td colspan='2' align='center'> <b> <font color='#000000' face='Arial' size='2'> Script Name :&nbsp;&nbsp;&nbsp;</font> <font color='#0000FF' face='Arial' size='2'>"
                            + scriptName + "</font></td>");
            bw1.write(
                    "<td colspan='1' align='left'> <b> <font color='#000000' face='Arial' size='2'> Start Time :&nbsp;</font> <font color='#0000FF' face='Arial' size='2'>"
                            + (String) startDateTime + "</font></td>");
            bw1.write("</tr>");
            bw1.write("</tr>");
            bw1.write(
                    "<td bgcolor='#ffd700' align='center'><b><font color='#000000' face='Arial' size='2'> S.no </font></b></td>");
            bw1.write(
                    "<td bgcolor='#ffd700' align='left'><b><font color='#000000' face='Arial' size='2'> Test case ID: Test Case Description </font></b></td>");
            bw1.write(
                    "<td bgcolor='#ffd700' align='left'><b><font color='#000000' face='Arial' size='2'>  Result </font></b></td>");
            bw1.write(
                    "<td bgcolor='#ffd700' align='left'><b><font color='#000000' face='Arial' size='2'>  Result description</font></b></td>");
            bw1.write("</tr>");

 

        }

 

        bw1.write("<tr>" + "\n");
        bw1.write("<td bgcolor='#FFFFDC' align='center'><font color='#000000' face='Arial' size='2'>" + index
                + "</font></td>");
        bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Arial' size='2'> "
                + testCaseName + " </font></b></td>");
        if (testCaseStatus == "Pass") {
            bw1.write(
                    "<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='Green' face='Arial' size='2'> "
                            + testCaseStatus + " </font></b></td>");
        } else {
            bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='Red' face='Arial' size='2'> "
                    + testCaseStatus + " </font></b></td>");
        }
        bw1.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Arial' size='2'> "
                + description + " </font></b></td>");
        bw1.write("</tr>" + "\n");
        bw1.write("</body>" + "\n");
        bw1.write("</html>");
        bw1.flush();
        bw1.close();

 

    }

 

}
 


