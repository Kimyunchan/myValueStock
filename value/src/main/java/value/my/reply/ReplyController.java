package value.my.reply;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	private ReplyService replyService;
	
	ReplyController(ReplyService replyservice){
		this.replyService = replyservice;
	}
	
	@PostMapping("/update")
	public String updateReply(@ModelAttribute ReplyDTO replyDTO) {
		
		replyDTO.updateDatetime = LocalDateTime.now();
		
		replyService.updateReply(replyDTO);
		
		return "redirect:/board/list/"+replyDTO.boardId;
	}	
	
	@PostMapping("/create")
	public String createReply(@ModelAttribute ReplyDTO replyDTO) {
		
		replyDTO.createDatetime = LocalDateTime.now();
		
		replyService.createReply(replyDTO);
		
		return "redirect:/board/list/"+replyDTO.boardId;
	}	
	
	@PostMapping("/delete")
	public String deleteReply(@ModelAttribute ReplyDTO replyDTO) {
		
		replyService.deleteReply(replyDTO.replyId);
		
		return "redirect:/board/list/"+replyDTO.boardId;
	}	
}
