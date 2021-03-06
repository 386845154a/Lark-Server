
package com.github.hollykunge.serviceunitproject.serviceimpl.servicebiz;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "synchrodata", targetNamespace = "http://impl.webservice.dev.casic.com", wsdlLocation = "file:/D:/projectunit/synchrodatauserposition.wsdl")
public class Synchrodata
    extends Service
{

    private final static URL SYNCHRODATA_WSDL_LOCATION;
    private final static WebServiceException SYNCHRODATA_EXCEPTION;
    private final static QName SYNCHRODATA_QNAME = new QName("http://impl.webservice.dev.casic.com", "synchrodata");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/projectunit/synchrodatauserposition.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SYNCHRODATA_WSDL_LOCATION = url;
        SYNCHRODATA_EXCEPTION = e;
    }

    public Synchrodata() {
        super(__getWsdlLocation(), SYNCHRODATA_QNAME);
    }

    public Synchrodata(WebServiceFeature... features) {
        super(__getWsdlLocation(), SYNCHRODATA_QNAME, features);
    }

    public Synchrodata(URL wsdlLocation) {
        super(wsdlLocation, SYNCHRODATA_QNAME);
    }

    public Synchrodata(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SYNCHRODATA_QNAME, features);
    }

    public Synchrodata(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Synchrodata(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpSoap11Endpoint")
    public SynchrodataPortType getSynchrodataHttpSoap11Endpoint() {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpSoap11Endpoint"), SynchrodataPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpSoap11Endpoint")
    public SynchrodataPortType getSynchrodataHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpSoap11Endpoint"), SynchrodataPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpSoap12Endpoint")
    public SynchrodataPortType getSynchrodataHttpSoap12Endpoint() {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpSoap12Endpoint"), SynchrodataPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpSoap12Endpoint")
    public SynchrodataPortType getSynchrodataHttpSoap12Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpSoap12Endpoint"), SynchrodataPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpEndpoint")
    public SynchrodataPortType getSynchrodataHttpEndpoint() {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpEndpoint"), SynchrodataPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SynchrodataPortType
     */
    @WebEndpoint(name = "synchrodataHttpEndpoint")
    public SynchrodataPortType getSynchrodataHttpEndpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.webservice.dev.casic.com", "synchrodataHttpEndpoint"), SynchrodataPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SYNCHRODATA_EXCEPTION!= null) {
            throw SYNCHRODATA_EXCEPTION;
        }
        return SYNCHRODATA_WSDL_LOCATION;
    }

}
