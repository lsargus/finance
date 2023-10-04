module br.com.lsargus.finance.domain {
    exports br.com.lsargus.finance.data;
    exports br.com.lsargus.finance.exceptions;
    exports br.com.lsargus.finance.ports.presistence;
    exports br.com.lsargus.finance.ports.service;
    requires lombok;
    requires spring.context;
}