package chzu.lujie.work.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chzu.lujie.work.base.DaoSupportImpl;
import chzu.lujie.work.dao.DepartmentDao;
import chzu.lujie.work.domain.Department;
import chzu.lujie.work.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl extends DaoSupportImpl<Department> implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	@Resource
	private SessionFactory sessionFactory;


	@Override
	public List<Department> findTopList() {

		return sessionFactory.getCurrentSession().createQuery(//
				"from Department d where d.parent is null ")//
				.list();//
	}

	@Override
	public List<Department> findChildrenList(Long parentId) {
		return sessionFactory.getCurrentSession().createQuery(//
				"from Department d where d.parent.id=? ")//
				.setParameter(0, parentId)//
				.list();//	
		
	}

	
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);

	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);

	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);

	}

	@Override
	public Department getById(Long id) {
		// TODO Auto-generated method stub
		return departmentDao.getById(id);
	}



}
