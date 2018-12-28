package pt.contabilidade.excels.motorRegras;

import java.util.Set;

import pt.contabilidade.excels.input.InputName;

public class Regra {

	private InputName text;

	private String type_piece;

	private String gl;

	private String code_tva;

	private String pc;

	private String obs;

	private Center center;

	private Set<String> matching_text;

	public Regra(InputName text, String type_piece, String gl, String code_tva, String pc, String obs, Center center,
			Set<String> matching_text) {
		super();
		this.text = text;
		this.type_piece = type_piece;
		this.gl = gl;
		this.code_tva = code_tva;
		this.pc = pc;
		this.obs = obs;
		this.center = center;
		this.matching_text = matching_text;
	}

	public Regra() {
	}

	public InputName getText() {
		return text;
	}

	public void setText(InputName text) {
		this.text = text;
	}

	public String getType_piece() {
		return type_piece;
	}

	public void setType_piece(String type_piece) {
		this.type_piece = type_piece;
	}

	public String getGl() {
		return gl;
	}

	public void setGl(String gl) {
		this.gl = gl;
	}

	public String getCode_tva() {
		return code_tva;
	}

	public void setCode_tva(String code_tva) {
		this.code_tva = code_tva;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Set<String> getMatching_text() {
		return matching_text;
	}

	public void setMatching_text(Set<String> matching_text) {
		this.matching_text = matching_text;
	}

}
