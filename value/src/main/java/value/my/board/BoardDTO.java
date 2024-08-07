package value.my.board;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO {

	public int id;
	public String content;
	public int authorId;
	@DateTimeFormat
	public LocalDateTime createDatetime;
	@DateTimeFormat
	public LocalDateTime updateDatetime;
	
	@ConstructorProperties({"id", "content", "authorId"})
	public BoardDTO(int id, String content, int authorId) {
		this.id = id;
		this.content = content;
		this.authorId = authorId;
	}
		
	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public int getAuthorId() {
		return authorId;
	}

	public LocalDateTime getCreateDatetime() {
		return createDatetime;
	}

	public LocalDateTime getUpdateDatetime() {
		return updateDatetime;
	}
	
	
	
}
