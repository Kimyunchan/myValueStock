package value.my.reply.infra;

import java.util.List;

import value.my.reply.ReplyDTO;

public interface ReplyRepository {

	List<ReplyDTO> getReplyList(int boardId);
	
	void createReply(ReplyDTO replyDTO);
	
	void updateReply(ReplyDTO replyDTO);
	
	void deleteReply(int replyId);
}
