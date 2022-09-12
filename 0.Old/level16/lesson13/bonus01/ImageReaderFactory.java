package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory
{
    public static ImageReader getReader (ImageTypes img)
    {
        if (img == ImageTypes.BMP) return new BmpReader();
        else if (img == ImageTypes.JPG) return new JpgReader();
        else if (img == ImageTypes.PNG) return new PngReader();
        else
        {
            throw new IllegalArgumentException();

        }

    }
}
