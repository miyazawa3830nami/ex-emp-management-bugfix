package jp.co.sample.emp_management.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * 管理者情報を登録します.
	 * 
	 * @param administrator 管理者情報
	 * @throws Exception 
	 */
//	public void insert(Administrator administrator) {
//		administratorRepository.insert(administrator);
//	}
	
	public void insert(Administrator administrator) throws Exception {
		String mailAddress = administrator.getMailAddress();
		if(administratorRepository.findByMailAddress(mailAddress) == null) {
			administratorRepository.insert(administrator);
		} else {
			throw new Exception("メールアドレスが重複しています");
		}
	}
	
	/**
	 * ログインをします.
	 * @param mailAddress メールアドレス
	 * @param password パスワード
	 * @return 管理者情報　存在しない場合はnullが返ります
	 */
	public Administrator login(String mailAddress, String password) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassward(mailAddress, password);
		return administrator;
	}
}
