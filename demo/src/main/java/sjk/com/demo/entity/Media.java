package sjk.com.demo.entity;
import jakarta.persistence.*;
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileID;

    @ManyToOne
    private Universities university;

    private String type; // 文件类型：图像/视频
    private String fileURL; // 文件URL

    // 构造函数
    public Media() {
    }

    // Getter 和 Setter 方法
    public Long getFileID() {
        return fileID;
    }

    public void setFileID(Long fileID) {
        this.fileID = fileID;
    }

    public Universities getUniversity() {
        return university;
    }

    public void setUniversity(Universities university) {
        this.university = university;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }
}
