package value.my.board;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO {

	public int id;
	public String title;
	public String content;
	public int authorId;
	public int replyCounts;
	@DateTimeFormat
	public LocalDateTime createDatetime;
	@DateTimeFormat
	public LocalDateTime updateDatetime;
	
	@ConstructorProperties({"id", "title", "content", "authorId"})
	public BoardDTO(int id, String title, String content, int authorId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.authorId = authorId;
	}
		
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}

	public int getAuthorId() {
		return authorId;
	}
	
	public int getReplyCounts() {
		return replyCounts;
	}

	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}

	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}
	
	
	
}
