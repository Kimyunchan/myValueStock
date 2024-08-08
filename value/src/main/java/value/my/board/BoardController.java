package value.my.board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import value.my.reply.ReplyDTO;
import value.my.reply.ReplyService;	

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	private ReplyService replyService;
	
	public BoardController(BoardService boardService, ReplyService replyService) {
		this.boardService = boardService;
		this.replyService = replyService;
	}

	@GetMapping("/list")
	public String list(Model model) {
		
		List<BoardDTO> list = boardService.getList();
				
		model.addAttribute("list", list);
		
		return "/board/board_list";
	}
	
	@GetMapping("/list/{id}")
	public String list(Model model, @PathVariable("id") int id) {
		
		BoardDTO boardDTO = boardService.getId(id);
		List<ReplyDTO> replyList = replyService.getReplyList(boardDTO.id);
		
		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("replyList", replyList);
		
		return "/board/board_detail";
	}
	
	@GetMapping("/create")
	public String getCreateBoard() {
		
		return "/board/board_create";
		
	}
	
	@PostMapping("/create")
	public String makeBoard(@ModelAttribute BoardDTO boardDTO) {
		
		boardDTO.createDatetime = LocalDateTime.now();
		boardService.createBoard(boardDTO);
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/update")
	public String getUdateBoard(BoardDTO boardDTO) {
				
		boardDTO = boardService.getId(boardDTO.id);
			
		return "/board/board_update";
		
	}
	
	@PostMapping("/update")
	public String updateBoard(@ModelAttribute BoardDTO boardDTO) {
		
		boardDTO.updateDatetime = LocalDateTime.now();
		
		boardService.updateBoard(boardDTO);
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable("id") int id) {
		
		boardService.deleteBoard(id);

		return "redirect:/board/list";
	}
	
}
