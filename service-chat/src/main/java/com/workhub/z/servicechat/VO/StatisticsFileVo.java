package com.workhub.z.servicechat.VO;

import lombok.Data;

/**
 * @auther: zhuqz
 * @date: 2020/3/25 13:57
 * @description: 附件信息统计
 */
@Data
public class StatisticsFileVo {
    private String fileCount;//总附件条数
    private String pirivateFileCount;//私聊附件条数
    private String groupFileCount;//群附件条数
    private String meetFileCount;//会议附件条数
    private  String textFileCount;//文本附件条数
    private String picFileCount;//图片附件条数
    private String zipFileCount;//压缩附件条数
    private String otherFileCount;//其他类型附件条数
}