package com.socio.utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ClipboardUtils {

    public static String readFromClipboard() throws IOException, UnsupportedFlavorException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        return  (String) clipboard.getData(DataFlavor.stringFlavor);
    }

    public static void writeToClipboard(String data){
        StringSelection ss = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }

    public static void pasteFromClipboard() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(250);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(250);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(250);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
