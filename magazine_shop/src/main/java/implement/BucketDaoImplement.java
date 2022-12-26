package implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.BucketDao;
import domain.Bucket;
import utilites.ConnectionUtils;

public class BucketDaoImplement implements BucketDao {

	private static String READ_ALL = "select * from bucket";
	private static String CREATE = "insert into bucket (`id_user`, `id_product`, `time_operation`) values(?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id = ?";
	private static String DELETE_BY_ID = "delete from bucket where id = ?";

	private static Logger LOGGER = Logger.getLogger(BucketDaoImplement.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImplement()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, new Date(bucket.getTimeOperation().getTime()));
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			bucket.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			LOGGER.error("Error - Bucket create (BucketDaoImplement) - ", e);
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			
			Integer bucketId = result.getInt("id");
			Integer userId = result.getInt("id_user");
			Integer productId = result.getInt("id_product");
			Date timeOperation = result.getDate("time_operation");

			bucket = new Bucket(bucketId, userId, productId, timeOperation);	
		} catch (SQLException e) {
			LOGGER.error("Error - Bucket read (BucketDaoImplement) - ", e);
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.error("Error - Bucket update (BucketDaoImplement) - ", e);
		}
	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> listBacket = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Integer bucketId = result.getInt("id");
				Integer userId = result.getInt("id_user");
				Integer productId = result.getInt("id_product");
				Date timeOperation = result.getDate("time_operation");

				listBacket.add(new Bucket(bucketId, userId, productId, timeOperation));	
			}
		} catch (SQLException e) {
			LOGGER.error("Error - List<Bucket> readAll (BucketDaoImplement) - ", e);
		}
		return listBacket;
	}

}
