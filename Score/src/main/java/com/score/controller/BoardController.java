package com.score.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.score.domain.dto.PageMaker;
import com.score.domain.dto.SearchCriteria;
import com.score.domain.vo.BoardVO;
import com.score.service.BoardServiceImpl;

@Controller
@RequestMapping("/Board")
public class BoardController {

	// github Test

	@Inject
	private BoardServiceImpl service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "/Board/BoardList";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET() throws Exception {

		return "/Board/BoardInsert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(BoardVO vo) throws Exception {
		vo.setBoardContent(vo.getBoardContent().replaceAll("\"", "\'"));
		service.insert(vo);

		return "redirect:/Board";
	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public String readPageGET(@RequestParam("boardNumber") int boardNumber, Model model) throws Exception {
		model.addAttribute("vo", service.readPage(boardNumber));

		return "/Board/BoardReadPage";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("boardNumber") int boardNumber, Model model) throws Exception {
		model.addAttribute("vo", service.readPage(boardNumber));

		return "/Board/BoardModifyPage";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO vo, RedirectAttributes rttr) throws Exception {
		service.modify(vo);

		return "redirect:/Board/readPage?boardNumber=" + vo.getBoardNumber();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteGET(@RequestParam("boardNumber") int boardNumber, Model model) throws Exception {

		service.delete(boardNumber);

		return "redirect:/Board";
	}

	// ck 이미지
	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response,
		MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception {
		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();

		/* OutputStream out = null; */
		PrintWriter printWriter = null;

		// 인코딩
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {

			// 파일 이름 가져오기
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();

			// 이미지 경로 생성
			String path = uploadPath + File.separator + "boardImg/";
			String sFileName = uid + "_" + fileName;
			
			File target = new File(path, sFileName);
			FileCopyUtils.copy(bytes, target);
			
			/*
			 * File folder = new File(path);
			 * 
			 * // 해당 디렉토리 확인 if (!folder.exists()) { try { folder.mkdirs(); // 폴더 생성 } catch
			 * (Exception e) { e.getStackTrace(); } }
			 */

			/*
			 * out = new FileOutputStream(new File(ckUploadPath));
			 * System.out.println(ckUploadPath); out.write(bytes); out.flush(); //
			 * outputStram에 저장된 데이터를 전송하고 초기화
			 */
			/* String callback = request.getParameter("CKEditorFuncNum"); */
			/* System.out.println(request.getParameter("CKEditorFuncNum")); */
			// CKEditorFuncNum 으로 받아와서 사용중인 ck를 정해야하나 null이뜨고 대부분 1로되어서 현재상태는 1
			printWriter = response.getWriter();
			
			//실제 파일이 저장되어있는 경로지정
			String fileUrl = "/score/resources/boardImg/"+ sFileName;

			// 업로드시 메시지 출력
			printWriter.println("{\"filename\" : \"" + sFileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}");
			printWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				/*
				 * if (out != null) { out.close(); }
				 */
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return;
	}

	/**
     * cKeditor 서버로 전송된 이미지 뿌려주기
     * @param uid
     * @param fileName
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    //
    @RequestMapping(value="/ckImgSubmit")
    public void ckSubmit(@RequestParam(value="fileName") String fileName
                            , HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException{
        
        //서버에 저장된 이미지 경로
        String path = uploadPath + File.separator + "boardImg/";
    
        String sDirPath = path + fileName;
    
        File imgFile = new File(sDirPath);
        
        //사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
        if(imgFile.isFile()){
            byte[] buf = new byte[1024];
            int readByte = 0;
            int length = 0;
            byte[] imgBuf = null;
            
            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = null;
            ServletOutputStream out = null;
            
            try{
                fileInputStream = new FileInputStream(imgFile);
                outputStream = new ByteArrayOutputStream();
                out = response.getOutputStream();
                
                while((readByte = fileInputStream.read(buf)) != -1){
                    outputStream.write(buf, 0, readByte);
                }
                
                imgBuf = outputStream.toByteArray();
                length = imgBuf.length;
                out.write(imgBuf, 0, length);
                out.flush();
                
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                outputStream.close();
                fileInputStream.close();
                out.close();
            }
        }
    }

}
