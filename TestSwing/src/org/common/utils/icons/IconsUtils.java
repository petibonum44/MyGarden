package org.common.utils.icons;

import javax.swing.ImageIcon;

public class IconsUtils {

	public static ImageIcon createSmallImageIcon(String name) {
			String path = "images/small_16_16/"+name;
            java.net.URL imgURL = IconsUtils.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL, path);
            } else {
                System.err.println("Couldn't find file: " + name);
                return null;
            }

		
	}
	public static ImageIcon createBigImageIcon(String name) {
		String path = "images/big_48_48/"+name;
        java.net.URL imgURL = IconsUtils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, path);
        } else {
            System.err.println("Couldn't find file: " + name);
            return null;
        }
	}
    public static ImageIcon createMediumImageIcon(String name) {
			String path = "images/medium_32_32/"+name;
            java.net.URL imgURL = IconsUtils.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL, path);
            } else {
                System.err.println("Couldn't find file: " + name);
                return null;
            }

		
	}
    public static ImageIcon createImageIcon(String name) {
		String path = "images/"+name;
        java.net.URL imgURL = IconsUtils.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, path);
        } else {
            System.err.println("Couldn't find file: " + name);
            return null;
        }

       

}


}
