package com.yanxin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PsfwTransfer {

	@ApiModelProperty(name = "psfw",value = "配送范围")
    private String psfw;

	public final String getPsfw() {
		return psfw;
	}

	public final void setPsfw(String psfw) {
		this.psfw = psfw;
	}

}