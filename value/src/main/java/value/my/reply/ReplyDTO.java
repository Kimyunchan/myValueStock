package value.my.reply;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ReplyDTO {
	
	public int replyId;
	public String content;
	public int boardId;
	public int authorId;
	@DateTimeFormat
	public LocalDateTime createDatetime;
	@DateTimeFormat
	public LocalDateTime updateDatetime;
	
	@ConstructorProperties({"replyId", "content", "boardId", "authorId"})
	public ReplyDTO(int replyId, String content, int boardId, int authorId){
		this.replyId = replyId;
		this.content = content;
		this.boardId = boardId;
		this.authorId = authorId;
	}

	public int getReplyId() {
		return replyId;
	}

	public String getContent() {
		return content;
	}
	
	public int getBoardId() {
		return boardId;
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
