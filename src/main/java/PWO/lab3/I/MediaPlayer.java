package PWO.lab3.I;

import java.io.File;

public interface MusicProcessor {
    Mp3 loadMusicFile(File f);

    void saveMusicFile(File f);

    Mp3 convertToMp3(Wave wave);

    Mp3 extractFromAvi(Avi avi);

    Mp3 extractFromMpeg(Mpeg mpeg);

    Mp3 filterMusic(Mp3 mp3);
}

public interface VideoProcessor {
    Mpeg loadVideoFile(File f);

    void saveVideoFile(File f);

    Avi convertToAvi(Mpeg mpeg);

    Mpeg filterVideo(Mpeg mpeg);
}

public interface PictureProcessor {
    Jpeg loadPicture(File f);

    void savePicture(File f);

    Jpeg addAuthorToPicture(Jpeg jpeg);
}

public interface FileManipulator {
    void cutFile(File f, double start, double end);
}

public interface EmailProcessor {
    void attachFileToEmail(File f);

    void sendEmail(Message m);

    Message[] readEmails(String server, String login, String pwd);
}

public interface FinalProcessor extends MusicProcessor, VideoProcessor, PictureProcessor, FileManipulator, EmailProcessor {
    String getFileDestination();

    Boolean isFileSaved();

    void playFile(File f);
}
