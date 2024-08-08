package value.my.reply;

import java.util.List;

import org.springframework.stereotype.Service;

import value.my.reply.infra.ReplyRepository;

@Service
public class ReplyService {
	
	private ReplyRepository replyRepository;
	
	ReplyService(ReplyRepository replyRepository){
		this.replyRepository = replyRepository;
	}
	
	public List<ReplyDTO> getReplyList(int boardId){
		return replyRepository.getReplyList(boardId);
	}
	
	public void createReply(ReplyDTO replyDTO) {
		replyRepository.createReply(replyDTO);
	}
	
	public void updateReply(ReplyDTO replyDTO) {
		replyRepository.updateReply(replyDTO);
	}
	
	public void deleteReply(int replyId) {
		replyRepository.deleteReply(replyId);
	}
	
}
