/*
 *  Copyright (C) 2010-2015 JPEXS, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. */
package com.jpexs.decompiler.flash.tags;

import com.jpexs.decompiler.flash.SWF;
import com.jpexs.decompiler.flash.SWFInputStream;
import com.jpexs.decompiler.flash.SWFOutputStream;
import com.jpexs.decompiler.flash.tags.base.BoundedTag;
import com.jpexs.decompiler.flash.tags.base.CharacterTag;
import com.jpexs.decompiler.flash.types.BasicType;
import com.jpexs.decompiler.flash.types.RECT;
import com.jpexs.decompiler.flash.types.annotations.Reserved;
import com.jpexs.decompiler.flash.types.annotations.SWFType;
import com.jpexs.helpers.ByteArrayRange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

/**
 *
 *
 * @author JPEXS
 */
public class DefineVideoStreamTag extends CharacterTag implements BoundedTag {

    @SWFType(BasicType.UI16)
    public int characterID;

    @SWFType(BasicType.UI16)
    public int numFrames;

    @SWFType(BasicType.UI16)
    public int width;

    @SWFType(BasicType.UI16)
    public int height;

    @Reserved
    @SWFType(value = BasicType.UB, count = 4)
    public int reserved;

    @SWFType(value = BasicType.UB, count = 3)
    public int videoFlagsDeblocking;

    public boolean videoFlagsSmoothing;

    @SWFType(BasicType.UI8)
    public int codecID;

    public static final int CODEC_SORENSON_H263 = 2;
    public static final int CODEC_SCREEN_VIDEO = 3;
    public static final int CODEC_VP6 = 4;
    public static final int CODEC_VP6_ALPHA = 5;
    public static final int ID = 60;

    @Override
    public int getCharacterId() {
        return characterID;
    }

    /**
     * Gets data bytes
     *
     * @return Bytes of data
     */
    @Override
    public byte[] getData() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = baos;
        SWFOutputStream sos = new SWFOutputStream(os, getVersion());
        try {
            sos.writeUI16(characterID);
            sos.writeUI16(numFrames);
            sos.writeUI16(width);
            sos.writeUI16(height);
            sos.writeUB(4, reserved);
            sos.writeUB(3, videoFlagsDeblocking);
            sos.writeUB(1, videoFlagsSmoothing ? 1 : 0);
            sos.writeUI8(codecID);
        } catch (IOException e) {
            throw new Error("This should never happen.", e);
        }
        return baos.toByteArray();
    }

    /**
     * Constructor
     *
     * @param swf
     */
    public DefineVideoStreamTag(SWF swf) {
        super(swf, ID, "DefineVideoStream", null);
        characterID = swf.getNextCharacterId();
    }

    /**
     * Constructor
     *
     * @param sis
     * @param data
     * @throws IOException
     */
    public DefineVideoStreamTag(SWFInputStream sis, ByteArrayRange data) throws IOException {
        super(sis.getSwf(), ID, "DefineVideoStream", data);
        characterID = sis.readUI16("characterID");
        numFrames = sis.readUI16("numFrames");
        width = sis.readUI16("width");
        height = sis.readUI16("height");
        reserved = (int) sis.readUB(4, "reserved");
        videoFlagsDeblocking = (int) sis.readUB(3, "videoFlagsDeblocking");
        videoFlagsSmoothing = sis.readUB(1, "videoFlagsSmoothing") == 1;
        codecID = sis.readUI8("codecID");
    }

    @Override
    public RECT getRect(Set<BoundedTag> added) {
        return new RECT(0, (int) (SWF.unitDivisor * width), 0, (int) (SWF.unitDivisor * height));
    }
}
