package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.Log;
import shaomai.dao.ArtDao;
import shaomai.exception.ArtSelectException;
import shaomai.model.p.ArtBean;
import shaomai.service.ArtService;

import java.util.List;

@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtDao artDao;

    @Autowired
    private Log logger;

    @Override
    public List<ArtBean> getAllArts(int pageNo,int pageSize) throws ArtSelectException {
        try {
            logger.info("获取所有文章列表的接口");
            return artDao.selectAll(pageNo, pageSize);
        } catch (Exception e) {
            logger.error("获取所有文章列表失败， 失败原因：" + e.getMessage());
            throw new ArtSelectException("文章查询失败");
        }
    }

    @Override
    public int artTotal() throws ArtSelectException {
        try {
            logger.info("获取所有文章总数接口");
            return artDao.artTotal();
        } catch (Exception e) {
            logger.error("获取文章总数失败，失败原因：" + e.getMessage());
            throw new ArtSelectException("文章查询失败");
        }
    }

    @Override
    public ArtBean getArtById(int id) throws ArtSelectException {
        try {
            logger.info("根据id获取文章信息");
            return artDao.selectArtById(id);
        } catch (Exception e) {
            logger.error("根据id获取文章信息失败，失败原因：" + e.getMessage());
            throw new ArtSelectException("文章查询失败");
        }
    }
}
