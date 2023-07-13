// Autogenerated from Pigeon (v10.1.3), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package io.flutter.plugins.firebase.firestore;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression", "serial"})
public class GeneratedAndroidFirebaseFirestore {

  /** Error class for passing custom error details to Flutter via a thrown PlatformException. */
  public static class FlutterError extends RuntimeException {

    /** The error code. */
    public final String code;

    /** The error details. Must be a datatype supported by the api codec. */
    public final Object details;

    public FlutterError(@NonNull String code, @Nullable String message, @Nullable Object details) {
      super(message);
      this.code = code;
      this.details = details;
    }
  }

  @NonNull
  protected static ArrayList<Object> wrapError(@NonNull Throwable exception) {
    ArrayList<Object> errorList = new ArrayList<Object>(3);
    if (exception instanceof FlutterError) {
      FlutterError error = (FlutterError) exception;
      errorList.add(error.code);
      errorList.add(error.getMessage());
      errorList.add(error.details);
    } else {
      errorList.add(exception.toString());
      errorList.add(exception.getClass().getSimpleName());
      errorList.add(
          "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    }
    return errorList;
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static final class PigeonFirebaseApp {
    private @NonNull String appName;

    public @NonNull String getAppName() {
      return appName;
    }

    public void setAppName(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"appName\" is null.");
      }
      this.appName = setterArg;
    }

    /** Constructor is non-public to enforce null safety; use Builder. */
    PigeonFirebaseApp() {}

    public static final class Builder {

      private @Nullable String appName;

      public @NonNull Builder setAppName(@NonNull String setterArg) {
        this.appName = setterArg;
        return this;
      }

      public @NonNull PigeonFirebaseApp build() {
        PigeonFirebaseApp pigeonReturn = new PigeonFirebaseApp();
        pigeonReturn.setAppName(appName);
        return pigeonReturn;
      }
    }

    @NonNull
    ArrayList<Object> toList() {
      ArrayList<Object> toListResult = new ArrayList<Object>(1);
      toListResult.add(appName);
      return toListResult;
    }

    static @NonNull PigeonFirebaseApp fromList(@NonNull ArrayList<Object> list) {
      PigeonFirebaseApp pigeonResult = new PigeonFirebaseApp();
      Object appName = list.get(0);
      pigeonResult.setAppName((String) appName);
      return pigeonResult;
    }
  }

  public interface Result<T> {
    @SuppressWarnings("UnknownNullness")
    void success(T result);

    void error(@NonNull Throwable error);
  }

  private static class FirebaseFirestoreHostApiCodec extends StandardMessageCodec {
    public static final FirebaseFirestoreHostApiCodec INSTANCE =
        new FirebaseFirestoreHostApiCodec();

    private FirebaseFirestoreHostApiCodec() {}

    @Override
    protected Object readValueOfType(byte type, @NonNull ByteBuffer buffer) {
      switch (type) {
        case (byte) 128:
          return PigeonFirebaseApp.fromList((ArrayList<Object>) readValue(buffer));
        default:
          return super.readValueOfType(type, buffer);
      }
    }

    @Override
    protected void writeValue(@NonNull ByteArrayOutputStream stream, Object value) {
      if (value instanceof PigeonFirebaseApp) {
        stream.write(128);
        writeValue(stream, ((PigeonFirebaseApp) value).toList());
      } else {
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter. */
  public interface FirebaseFirestoreHostApi {

    void registerIdTokenListener(@NonNull PigeonFirebaseApp app, @NonNull Result<String> result);

    /** The codec used by FirebaseFirestoreHostApi. */
    static @NonNull MessageCodec<Object> getCodec() {
      return FirebaseFirestoreHostApiCodec.INSTANCE;
    }
    /**
     * Sets up an instance of `FirebaseFirestoreHostApi` to handle messages through the
     * `binaryMessenger`.
     */
    static void setup(
        @NonNull BinaryMessenger binaryMessenger, @Nullable FirebaseFirestoreHostApi api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(
                binaryMessenger,
                "dev.flutter.pigeon.FirebaseFirestoreHostApi.registerIdTokenListener",
                getCodec());
        if (api != null) {
          channel.setMessageHandler(
              (message, reply) -> {
                ArrayList<Object> wrapped = new ArrayList<Object>();
                ArrayList<Object> args = (ArrayList<Object>) message;
                PigeonFirebaseApp appArg = (PigeonFirebaseApp) args.get(0);
                Result<String> resultCallback =
                    new Result<String>() {
                      public void success(String result) {
                        wrapped.add(0, result);
                        reply.reply(wrapped);
                      }

                      public void error(Throwable error) {
                        ArrayList<Object> wrappedError = wrapError(error);
                        reply.reply(wrappedError);
                      }
                    };

                api.registerIdTokenListener(appArg, resultCallback);
              });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
}
