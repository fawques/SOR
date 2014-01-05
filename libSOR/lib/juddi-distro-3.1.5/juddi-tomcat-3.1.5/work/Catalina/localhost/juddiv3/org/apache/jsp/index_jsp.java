package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.apache.juddi.config.Install;
import javax.xml.bind.JAXBException;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.apache.juddi.config.AppConfig;
import org.apache.juddi.config.Property;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.Description;
import java.io.IOException;
import org.apache.juddi.config.Release;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- index.jsp -->\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Apache jUDDI Registry</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"juddi.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"header\" align=\"right\"><a href=\"http://juddi.apache.org/\" target=\"_top\">jUDDI@Apache</a></div>\r\n");
      out.write("        <h1>Apache jUDDI version ");
      out.print( Release.getRegistryVersion());
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h3><em>Welcome</em> to Apache jUDDI!</h3>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"/pluto/portal/jUDDI\">jUDDI Portal</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"happy.jsp\">jUDDI Status</a></li>\r\n");
      out.write("            <li><a href=\"services\">View</a> service listing</li>\r\n");
      out.write("            <li><a href=\"http://juddi.apache.org/\">Visit</a> the Apache-jUDDI Home Page</li>\r\n");
      out.write("            <li><a href=\"http://juddi.apache.org/docs/3.x/userguide/html/index.html\">Users Guide</a></li>\r\n");
      out.write("            <li><a href=\"http://juddi.apache.org/docs/3.x/devguide/html/index.html\" >Developers Guide</a></li>\r\n");
      out.write("            <li><a href=\"http://juddi.apache.org/docs.html\" >API Documentation</a></li>\r\n");
      out.write("            <li><a href=\"http://wiki.apache.org/juddi\" >jUDDI Wiki</a></li>\r\n");
      out.write("            <li><a href=\"http://juddi.apache.org/issue-tracking.html\" >Report a bug</a></li>\r\n");
      out.write("            <li><a href=\"http://svn.apache.org/viewvc/juddi/\" >jUDDI Source Code</a></li>\r\n");
      out.write("            <li><a href=\"http://www.nabble.com/jUDDI-f218.html\">Mailing list</a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"install\">\r\n");
      out.write("            <h4>jUDDI Installation</h4>\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                ");

                    // This will tirgger the install process...
                    String rootPartition = AppConfig.getConfiguration().getString(Property.JUDDI_ROOT_PARTITION);
                    String nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID);
                    String nodeName = "";
                    String nodeDescription = "";

                    BusinessEntity be = Install.getNodeBusinessEntity(nodeId);

                    if (be != null) {
                        Name n = (Name) be.getName().get(0);
                        if (n != null) {
                            nodeName = n.getValue();
                        }

                        List descList = be.getDescription();
                        if (descList != null && descList.size() > 0) {
                            Description d = (Description) descList.get(0);
                            if (d != null) {
                                nodeDescription = d.getValue();
                            }
                        }
                    }
                
      out.write("\r\n");
      out.write("                <div>jUDDI has been successfully installed!</div>\r\n");
      out.write("                <p />\r\n");
      out.write("                <h3>Node Information</h3>\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Root Partition:</b></td>\r\n");
      out.write("                        <td>");
      out.print( rootPartition);
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Node Id:</b></td>\r\n");
      out.write("                        <td>");
      out.print( nodeId);
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Name:</b></td>\r\n");
      out.write("                        <td>");
      out.print( nodeName);
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Description:</b></td>\r\n");
      out.write("                        <td>");
      out.print( nodeDescription);
      out.write("</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <hr />\r\n");
      out.write("        <table width=\"100%\" border=\"0\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td height=\"50\" align=\"center\" valign=\"bottom\" nowrap>\r\n");
      out.write("                    <div class=\"footer\">&nbsp;</div>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
