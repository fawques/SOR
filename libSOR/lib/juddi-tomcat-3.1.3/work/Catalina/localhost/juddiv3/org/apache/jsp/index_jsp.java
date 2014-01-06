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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- index.jsp -->\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Apache jUDDI Registry</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"juddi.css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"header\" align=\"right\"><a href=\"http://ws.apache.org/juddi/\" target=\"_top\">jUDDI@Apache</a></div>\n");
      out.write("<h1>Apache jUDDI version ");
      out.print( Release.getRegistryVersion() );
      out.write("</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h3><em>Welcome</em> to Apache jUDDI!</h3>\n");
      out.write("<div class=\"install\">\n");
      out.write("<h4>jUDDI Documentation</h4>\n");
      out.write("    <div class=\"content\">\n");
      out.write("\t<table><tr>\n");
      out.write("\t<td>\n");
      out.write("\t<ul>\n");
      out.write("\t    <li><a href=\"/pluto/portal/jUDDI\">jUDDI Portal</a></li>\n");
      out.write("\t    <li><a href=\"services\">View</a> service listing</li>\n");
      out.write("\t    <li><a href=\"http://ws.apache.org/juddi/\">Visit</a> the Apache-jUDDI Home Page</li>\n");
      out.write("\t    <li><a href=\"http://issues.apache.org/jira/browse/JUDDI\">Report</a> a bug</li>\n");
      out.write("\t    <li><a href=\"http://ws.apache.org/juddi/participate.html\">Participate! We love you..</a></li>\n");
      out.write("\t    <li><a href=\"http://ws.apache.org/juddi/library.html\">UDDI library</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t</td>\n");
      out.write("\t<td>\n");
      out.write("\t<ul>\n");
      out.write("\t    <li><a href=\"http://ws.apache.org/juddi/docs/3.0/userguide/pdf/userguide.pdf\">jUDDI User Guide</a></li>\n");
      out.write("\t    <li><a href=\"http://ws.apache.org/juddi/docs/3.0/userguide/pdf/devguide.pdf\">jUDDI Developer Guide</a></li>\n");
      out.write("\t    <li><a href=\"http://svn.apache.org/repos/asf/webservices/juddi/trunk/docs/uddi3-specification/uddi-v3.0.2-20041019.pdf\">UDDI v3.0.2 Specification</a></li>\n");
      out.write("\t    <li><a href=\"http://wiki.apache.org/ws/jUDDI\">jUDDI wiki</a> - add your own docs</li>\n");
      out.write("\t    <li><a href=\"http://apachejuddi.blogspot.com/\">jUDDI Blog</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t</td>\n");
      out.write("\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"install\">\n");
      out.write("  <h4>jUDDI Installation</h4>\n");
      out.write("    <div class=\"content\">\n");

    // This will trigger the install process...
    String rootPartition = AppConfig.getConfiguration().getString(Property.JUDDI_ROOT_PARTITION);
	String nodeId = AppConfig.getConfiguration().getString(Property.JUDDI_NODE_ID);
    String nodeName = "";
    String nodeDescription = "";
    
    BusinessEntity be = Install.getNodeBusinessEntity(nodeId);
    
    if (be != null) {
        Name n = (Name) be.getName().get(0);
        if (n != null)
            nodeName = n.getValue();

        List descList = be.getDescription();
        if (descList != null && descList.size() > 0) {
            Description d = (Description) descList.get(0);
            if (d != null)
                nodeDescription = d.getValue();
        }
    }

      out.write("\n");
      out.write("    <div>jUDDI has been successfully installed!</div>\n");
      out.write("    <p />\n");
      out.write("    <h3>Node Information</h3>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <td><b>Root Partition:</b></td>\n");
      out.write("            <td>");
      out.print( rootPartition );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td><b>Node Id:</b></td>\n");
      out.write("            <td>");
      out.print( nodeId );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td><b>Name:</b></td>\n");
      out.write("            <td>");
      out.print( nodeName );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td><b>Description:</b></td>\n");
      out.write("            <td>");
      out.print( nodeDescription );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<hr />\n");
      out.write("<table width=\"100%\" border=\"0\">\n");
      out.write("    <tr>\n");
      out.write("        <td height=\"50\" align=\"center\" valign=\"bottom\" nowrap>\n");
      out.write("        <div class=\"footer\">&nbsp;</div>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
