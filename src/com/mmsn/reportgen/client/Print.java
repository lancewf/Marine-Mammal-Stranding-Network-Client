package com.mmsn.reportgen.client;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.UIObject;

/** 
 * <pre> 
 * Generic printing class 
 * can be used to print the Window it self, DOM.Elements, UIObjects 
   (Widgets) and plain HTML 
 * 
 * Usage: 
 *      You must insert this iframe in your host page: 
 *              <iframe id="__printingFrame" 
style="width:0;height:0;border:0"></iframe> 
 * 
 *      Window: 
 *              Print.it(); 
 * 
 *      Objects/HTML: 
 *              Print.it(RootPanel.get("myId")); 
 *              Print.it(DOM.getElementById("myId")); 
 *              Print.it("Just <b>Print.it()</b>!"); 
 * 
 *      Objects/HTML using styles: 
 *              Print.it("<link rel='StyleSheet' type='text/css' 
media='paper' href='/paperStyle.css'>", RootPanel.get('myId')); 
 *              Print.it("<style type='text/css' media='paper'> .newPage { 
page-break-after: always; } </style>", 
 * 
"Hi<p class='newPage'></p>By"); 
 * </pre> 
 */ 
public class Print
{
   /**
    * If true, use a Timer instead of DeferredCommand to print the internal fram
    */
   public static boolean USE_TIMER     = false;

   /**
    * Time in seconds to wait before printing the internal frame when using Timer
    */
   public static int TIMER_DELAY       = 2;


   public static native void it() /*-{
       $wnd.print();
   }-*/;

   public static void it(UIObject obj) {
       it("", obj);
   }

   public static void it(Element element) {
       it("", element);
   }

   public static void it(String style, UIObject obj) {
       it(style, obj.getElement());
   }

   public static void it(String style, Element element) {
       it("", style, element);
   }

   public static void it(String docType, String style, Element element) {
       it(docType, style, DOM.toString(element));
   }

   public static void it(String docType, String style, String it) {
       it(docType
          +"<html>"
          +"<head>"
          +"<title>San Juan County Marine Mammal Stranding Network</title>"
          +"<meta http-equiv=\"Content-Type\"          content=\"text/html; charset=utf-8\">"
          +"<meta http-equiv=\"Content-Style-Type\"    content=\"text/css\">"
          +    style
          +"</head>"+"<body>"
          +    it
          +"</body>"+
          "</html>");
   }

   public static void it(String html) {
       try {
           buildFrame(html);

           if (USE_TIMER) {
               Timer timer     = new Timer() {
                       public void run() {
                           printFrame();
                       }
                   };
               timer.schedule(TIMER_DELAY * 1000);
           } else {
               DeferredCommand.addCommand(new Command() {
                       public void execute() {
                           printFrame();
                       }
                   });
           }

       } catch (Throwable exc) {
           Window.alert(exc.getMessage());
       }
   }

   public static native void buildFrame(String html) /*-{
       var frame = $doc.getElementById('__printingFrame');
       if (!frame) {
           $wnd.alert("Error: Can't find printing frame.");
           return;
       }
       var doc = frame.contentWindow.document;
       doc.open();
       doc.write(html);
       doc.close();

   }-*/;

   public static native void printFrame() /*-{
       var frame = $doc.getElementById('__printingFrame');
       frame = frame.contentWindow;
       frame.focus();
       frame.print();
   }-*/;

}
