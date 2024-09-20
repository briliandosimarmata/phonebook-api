package id.briliando.phonebookapi.core.contact;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Contact {
    private String id;
    private String name;
    private String phoneNumber;
    private byte[] avatar;
    private Long version;

    public Contact() {
    }

    public Contact(String id, String name, String phoneNumber, byte[] avatar, Long version) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.version = version;
    }

    public void valNameMaxLength() {
        int maxLength = 100;

        //validasi panjang nama tidak lebih dari 100 karakter
        if (name.length() > maxLength) {
            throw new RuntimeException("Nama kontak tidak boleh melebihi " + maxLength + " karakter.");
        }
    }

    public void valPhoneNumberMaxLength() {
        int maxLength = 14;

        //validasi panjang nomor hp tidak lebih dari 14 karakter
        if (this.phoneNumber.length() > 14) {
            throw new RuntimeException("Nomor HP tidak boleh melebihi " + maxLength + " karakter.");
        }
    }

    public void valPhoneNumberOnlyContainsNumeric() {
        //validasi format nomor hp hanya boleh mengandung angka
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(this.phoneNumber);

        if (matcher.find()) {
            throw new RuntimeException("Nomor HP hanya boleh mengandung angka.");
        }
    }

    public void valAvatarMaxLength() {
        int maxLength = 50;

        if (this.avatar.length > 50 * 1024) {
            throw new RuntimeException("Ukuran file maksimal hanya " + maxLength + " kB.");
        }
    }

    public void valAvatarFileTypeMustBeJPG() {
        if (this.avatar != null && this.avatar.length < 3) {
            throw new RuntimeException("Avatar file type must be JPG.");
        }

        //magic signature jpg file type
        boolean isFileTypeJPG = this.avatar != null && this.avatar.length > 3
                && (this.avatar[0] & 0xFF) == 0xFF
                && (this.avatar[1] & 0xFF) == 0xD8
                && (this.avatar[2] & 0xFF) == 0xFF;

        if (!isFileTypeJPG) {
            throw new RuntimeException("Avatar file type must be JPG.");
        }
    }
}
