package service.implement;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import dao.BucketDao;
import domain.Bucket;
import implement.BucketDaoImplement;
import service.BucketService;

public class BucketServiceImplement implements BucketService {

	private static Logger LOGGER = Logger.getLogger(BucketServiceImplement.class);
	private static BucketService bucketServiceImplement;
	private BucketDao bucketDao;

	private BucketServiceImplement() {

		try {
			bucketDao = new BucketDaoImplement();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error("Error - BucketServiceImplement - ", e);
		}
	}

	public static BucketService getBucketService() {
		if (bucketServiceImplement == null) {
			bucketServiceImplement = new BucketServiceImplement();
		}
		return bucketServiceImplement;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
