package im.actor.core.api.updates;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class UpdateMessageReadByMe extends Update {

    public static final int HEADER = 0x32;
    public static UpdateMessageReadByMe fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateMessageReadByMe(), data);
    }

    private ApiPeer peer;
    private long startDate;
    private Integer unreadCounter;

    public UpdateMessageReadByMe(@NotNull ApiPeer peer, long startDate, @Nullable Integer unreadCounter) {
        this.peer = peer;
        this.startDate = startDate;
        this.unreadCounter = unreadCounter;
    }

    public UpdateMessageReadByMe() {

    }

    @NotNull
    public ApiPeer getPeer() {
        return this.peer;
    }

    public long getStartDate() {
        return this.startDate;
    }

    @Nullable
    public Integer getUnreadCounter() {
        return this.unreadCounter;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiPeer());
        this.startDate = values.getLong(2);
        this.unreadCounter = values.optInt(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        writer.writeLong(2, this.startDate);
        if (this.unreadCounter != null) {
            writer.writeInt(3, this.unreadCounter);
        }
    }

    @Override
    public String toString() {
        String res = "update MessageReadByMe{";
        res += "peer=" + this.peer;
        res += ", startDate=" + this.startDate;
        res += ", unreadCounter=" + this.unreadCounter;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}