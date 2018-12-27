package com.baizhi.fl.controller;

/**
 * Created by lenovo on 2018/7/7.
 */

 /*

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("testImg")
    @ResponseBody
    public  void testImg(HttpServletRequest request, MultipartFile image){
       String realPath = request.getSession().getServletContext().getRealPath("/");
        // 在真实路径下 创建 一个新的文件夹 video
        realPath=realPath+"video";  // 新文件夹的路径
        File file = new File(realPath);
        if(!file.exists()){ //判断 如果文件  不存在 则创建
            file.mkdir();
        }
        //获取文件名
        String originalFilename = image.getOriginalFilename();
        // 调用 工具类 将文件名拆分 获取后缀名
        String extension = FilenameUtils.getExtension(originalFilename);
        //防止文件上传文件名相同被覆盖  使用 uuid
        UUID uuid = UUID.randomUUID();
        //拼接形成新的文件名
        String newName=uuid+"."+extension;
        //给文件加上路径名
        newName=realPath+"/"+newName;
        //上传文件
        try {
            image.transferTo(new File(newName));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
*/
