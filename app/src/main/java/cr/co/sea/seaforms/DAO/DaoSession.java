package cr.co.sea.seaforms.DAO;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import cr.co.sea.seaforms.Model.Formulario;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import cr.co.sea.seaforms.Model.Cliente;
import cr.co.sea.seaforms.Model.Contrato;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig clienteDaoConfig;
    private final DaoConfig contratoDaoConfig;
    private final DaoConfig formularioDaoConfig;

    private final ClienteDao clienteDao;
    private final ContratoDao contratoDao;
    private final FormularioDao formularioDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        clienteDaoConfig = daoConfigMap.get(ClienteDao.class).clone();
        clienteDaoConfig.initIdentityScope(type);

        contratoDaoConfig = daoConfigMap.get(ContratoDao.class).clone();
        contratoDaoConfig.initIdentityScope(type);

        formularioDaoConfig = daoConfigMap.get(FormularioDao.class).clone();
        formularioDaoConfig.initIdentityScope(type);

        clienteDao = new ClienteDao(clienteDaoConfig, this);
        contratoDao = new ContratoDao(contratoDaoConfig, this);
        formularioDao = new FormularioDao(formularioDaoConfig, this);

        registerDao(Cliente.class, clienteDao);
        registerDao(Contrato.class, contratoDao);
        registerDao(Formulario.class, formularioDao);
    }
    
    public void clear() {
        clienteDaoConfig.getIdentityScope().clear();
        contratoDaoConfig.getIdentityScope().clear();
        formularioDaoConfig.getIdentityScope().clear();
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public ContratoDao getContratoDao() {
        return contratoDao;
    }

    public FormularioDao getFormularioDao() {
        return formularioDao;
    }

}
