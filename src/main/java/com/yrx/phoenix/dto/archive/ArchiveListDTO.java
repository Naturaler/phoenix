package com.yrx.phoenix.dto.archive;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by r.x on 2019/3/3.
 */
@Data
public class ArchiveListDTO {
    private List<ArchiveDTO> archiveList;

    @Data
    public static class ArchiveDTO {
        private String year;
        private String title;
        @JsonFormat(pattern = "MM-dd")
        private Date insertTime;

    }
}
