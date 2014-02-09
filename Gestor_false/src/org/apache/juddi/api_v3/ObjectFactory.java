
package org.apache.juddi.api_v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.uddi.api_v3.DeleteTModel;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.juddi.api_v3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeletePublisher_QNAME = new QName("urn:juddi-apache-org:api_v3", "delete_publisher");
    private final static QName _GetAllPublisherDetail_QNAME = new QName("urn:juddi-apache-org:api_v3", "get_allPublisherDetail");
    private final static QName _DeleteClientSubscriptionInfo_QNAME = new QName("urn:juddi-apache-org:api_v3", "delete_ClientSubscriptionInfo");
    private final static QName _SyncSubscription_QNAME = new QName("urn:juddi-apache-org:api_v3", "sync_subscription");
    private final static QName _SyncSubscriptionDetail_QNAME = new QName("urn:juddi-apache-org:api_v3", "sync_subscriptionDetail");
    private final static QName _SaveClientSubscriptionInfo_QNAME = new QName("urn:juddi-apache-org:api_v3", "save_ClientSubscriptionInfo");
    private final static QName _PublisherDetail_QNAME = new QName("urn:juddi-apache-org:api_v3", "publisherDetail");
    private final static QName _Publisher_QNAME = new QName("urn:juddi-apache-org:api_v3", "publisher");
    private final static QName _InvokeSyncSubscription_QNAME = new QName("urn:juddi-apache-org:api_v3", "invoke_SyncSubscription");
    private final static QName _AdminDeleteTmodel_QNAME = new QName("urn:juddi-apache-org:api_v3", "adminDelete_tmodel");
    private final static QName _SaveClerk_QNAME = new QName("urn:juddi-apache-org:api_v3", "save_Clerk");
    private final static QName _SaveNode_QNAME = new QName("urn:juddi-apache-org:api_v3", "save_Node");
    private final static QName _GetPublisherDetail_QNAME = new QName("urn:juddi-apache-org:api_v3", "get_publisherDetail");
    private final static QName _SavePublisher_QNAME = new QName("urn:juddi-apache-org:api_v3", "save_publisher");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.juddi.api_v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteClientSubscriptionInfo }
     * 
     */
    public DeleteClientSubscriptionInfo createDeleteClientSubscriptionInfo() {
        return new DeleteClientSubscriptionInfo();
    }

    /**
     * Create an instance of {@link SaveClerkInfo }
     * 
     */
    public SaveClerkInfo createSaveClerkInfo() {
        return new SaveClerkInfo();
    }

    /**
     * Create an instance of {@link GetPublisherDetail }
     * 
     */
    public GetPublisherDetail createGetPublisherDetail() {
        return new GetPublisherDetail();
    }

    /**
     * Create an instance of {@link GetAllPublisherDetail }
     * 
     */
    public GetAllPublisherDetail createGetAllPublisherDetail() {
        return new GetAllPublisherDetail();
    }

    /**
     * Create an instance of {@link Publisher }
     * 
     */
    public Publisher createPublisher() {
        return new Publisher();
    }

    /**
     * Create an instance of {@link PublisherDetail }
     * 
     */
    public PublisherDetail createPublisherDetail() {
        return new PublisherDetail();
    }

    /**
     * Create an instance of {@link SyncSubscription }
     * 
     */
    public SyncSubscription createSyncSubscription() {
        return new SyncSubscription();
    }

    /**
     * Create an instance of {@link SaveNoodeInfo }
     * 
     */
    public SaveNoodeInfo createSaveNoodeInfo() {
        return new SaveNoodeInfo();
    }

    /**
     * Create an instance of {@link SavePublisher }
     * 
     */
    public SavePublisher createSavePublisher() {
        return new SavePublisher();
    }

    /**
     * Create an instance of {@link DeletePublisher }
     * 
     */
    public DeletePublisher createDeletePublisher() {
        return new DeletePublisher();
    }

    /**
     * Create an instance of {@link SaveClientSubscriptionInfo }
     * 
     */
    public SaveClientSubscriptionInfo createSaveClientSubscriptionInfo() {
        return new SaveClientSubscriptionInfo();
    }

    /**
     * Create an instance of {@link SyncSubscriptionDetail }
     * 
     */
    public SyncSubscriptionDetail createSyncSubscriptionDetail() {
        return new SyncSubscriptionDetail();
    }

    /**
     * Create an instance of {@link ClientSubscriptionInfoDetail }
     * 
     */
    public ClientSubscriptionInfoDetail createClientSubscriptionInfoDetail() {
        return new ClientSubscriptionInfoDetail();
    }

    /**
     * Create an instance of {@link ClerkDetail }
     * 
     */
    public ClerkDetail createClerkDetail() {
        return new ClerkDetail();
    }

    /**
     * Create an instance of {@link ClientSubscriptionInfo }
     * 
     */
    public ClientSubscriptionInfo createClientSubscriptionInfo() {
        return new ClientSubscriptionInfo();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link Clerk }
     * 
     */
    public Clerk createClerk() {
        return new Clerk();
    }

    /**
     * Create an instance of {@link NodeDetail }
     * 
     */
    public NodeDetail createNodeDetail() {
        return new NodeDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePublisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "delete_publisher")
    public JAXBElement<DeletePublisher> createDeletePublisher(DeletePublisher value) {
        return new JAXBElement<DeletePublisher>(_DeletePublisher_QNAME, DeletePublisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPublisherDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "get_allPublisherDetail")
    public JAXBElement<GetAllPublisherDetail> createGetAllPublisherDetail(GetAllPublisherDetail value) {
        return new JAXBElement<GetAllPublisherDetail>(_GetAllPublisherDetail_QNAME, GetAllPublisherDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClientSubscriptionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "delete_ClientSubscriptionInfo")
    public JAXBElement<DeleteClientSubscriptionInfo> createDeleteClientSubscriptionInfo(DeleteClientSubscriptionInfo value) {
        return new JAXBElement<DeleteClientSubscriptionInfo>(_DeleteClientSubscriptionInfo_QNAME, DeleteClientSubscriptionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncSubscription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "sync_subscription")
    public JAXBElement<SyncSubscription> createSyncSubscription(SyncSubscription value) {
        return new JAXBElement<SyncSubscription>(_SyncSubscription_QNAME, SyncSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncSubscriptionDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "sync_subscriptionDetail")
    public JAXBElement<SyncSubscriptionDetail> createSyncSubscriptionDetail(SyncSubscriptionDetail value) {
        return new JAXBElement<SyncSubscriptionDetail>(_SyncSubscriptionDetail_QNAME, SyncSubscriptionDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveClientSubscriptionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "save_ClientSubscriptionInfo")
    public JAXBElement<SaveClientSubscriptionInfo> createSaveClientSubscriptionInfo(SaveClientSubscriptionInfo value) {
        return new JAXBElement<SaveClientSubscriptionInfo>(_SaveClientSubscriptionInfo_QNAME, SaveClientSubscriptionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublisherDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "publisherDetail")
    public JAXBElement<PublisherDetail> createPublisherDetail(PublisherDetail value) {
        return new JAXBElement<PublisherDetail>(_PublisherDetail_QNAME, PublisherDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Publisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "publisher")
    public JAXBElement<Publisher> createPublisher(Publisher value) {
        return new JAXBElement<Publisher>(_Publisher_QNAME, Publisher.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SyncSubscription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "invoke_SyncSubscription")
    public JAXBElement<SyncSubscription> createInvokeSyncSubscription(SyncSubscription value) {
        return new JAXBElement<SyncSubscription>(_InvokeSyncSubscription_QNAME, SyncSubscription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "adminDelete_tmodel")
    public JAXBElement<DeleteTModel> createAdminDeleteTmodel(DeleteTModel value) {
        return new JAXBElement<DeleteTModel>(_AdminDeleteTmodel_QNAME, DeleteTModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveClerkInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "save_Clerk")
    public JAXBElement<SaveClerkInfo> createSaveClerk(SaveClerkInfo value) {
        return new JAXBElement<SaveClerkInfo>(_SaveClerk_QNAME, SaveClerkInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveNoodeInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "save_Node")
    public JAXBElement<SaveNoodeInfo> createSaveNode(SaveNoodeInfo value) {
        return new JAXBElement<SaveNoodeInfo>(_SaveNode_QNAME, SaveNoodeInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPublisherDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "get_publisherDetail")
    public JAXBElement<GetPublisherDetail> createGetPublisherDetail(GetPublisherDetail value) {
        return new JAXBElement<GetPublisherDetail>(_GetPublisherDetail_QNAME, GetPublisherDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePublisher }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:juddi-apache-org:api_v3", name = "save_publisher")
    public JAXBElement<SavePublisher> createSavePublisher(SavePublisher value) {
        return new JAXBElement<SavePublisher>(_SavePublisher_QNAME, SavePublisher.class, null, value);
    }

}
