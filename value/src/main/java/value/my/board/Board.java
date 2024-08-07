package value.my.board;

import java.time.LocalDateTime;

public class Board {

	private int id;
	private String content;
	private int authorId;
	private LocalDateTime createDatetime;
	public LocalDateTime updateDatetime;
	
	public Board(int id, String content, int authorId, LocalDateTime createDatetime) {
		this.id = id;
		this.content = content;
		this.authorId = authorId;
		this.createDatetime = createDatetime;
	}
	
	public Board(int id, String content, int authorId, LocalDateTime createDatetime,LocalDateTime updateDatetime) {
		this.id = id;
		this.content = content;
		this.authorId = authorId;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
	}
	
	public Board(Builder builder) {
		this.id = builder.id;
		this.content = builder.content;
		this.authorId = builder.authorId;
		this.createDatetime = builder.createDatetime;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private int id;
		private String content;
		private int authorId;
		private LocalDateTime createDatetime;
		
		public Builder() {
			
		}
		
		public Builder id(int id) {
	      this.id = id;
	      return this;
	    }

	    public Builder content(String content) {
	      this.content = content;
	      return this;
	    }

	    public Builder authorId(int authorId) {
	      this.authorId = authorId;
	      return this;
	    }

	    public Builder createDatetime(LocalDateTime createDatetime) {
	      this.createDatetime = createDatetime;
	      return this;
	    }

		public Board build() {
			return new Board(this);
		}
	}
	
	public BoardDTO toDto() {
		return new BoardDTO(id,content,authorId);
	}
}
