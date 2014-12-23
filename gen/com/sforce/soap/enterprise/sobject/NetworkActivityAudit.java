package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class NetworkActivityAudit extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public NetworkActivityAudit() {}

    /**
     * element : Action of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Action__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Action","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Action__is_set = false;

    private java.lang.String Action;

    public java.lang.String getAction() {
      return Action;
    }

    public void setAction(java.lang.String Action) {
      this.Action = Action;
      Action__is_set = true;
    }

    /**
     * element : CreatedBy of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedBy","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean CreatedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.User CreatedBy;

    public com.sforce.soap.enterprise.sobject.User getCreatedBy() {
      return CreatedBy;
    }

    public void setCreatedBy(com.sforce.soap.enterprise.sobject.User CreatedBy) {
      this.CreatedBy = CreatedBy;
      CreatedBy__is_set = true;
    }

    /**
     * element : CreatedById of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedById__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedById","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean CreatedById__is_set = false;

    private java.lang.String CreatedById;

    public java.lang.String getCreatedById() {
      return CreatedById;
    }

    public void setCreatedById(java.lang.String CreatedById) {
      this.CreatedById = CreatedById;
      CreatedById__is_set = true;
    }

    /**
     * element : CreatedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo CreatedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CreatedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean CreatedDate__is_set = false;

    private java.util.Calendar CreatedDate;

    public java.util.Calendar getCreatedDate() {
      return CreatedDate;
    }

    public void setCreatedDate(java.util.Calendar CreatedDate) {
      this.CreatedDate = CreatedDate;
      CreatedDate__is_set = true;
    }

    /**
     * element : Description of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Description__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Description","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Description__is_set = false;

    private java.lang.String Description;

    public java.lang.String getDescription() {
      return Description;
    }

    public void setDescription(java.lang.String Description) {
      this.Description = Description;
      Description__is_set = true;
    }

    /**
     * element : Entity of type {urn:sobject.enterprise.soap.sforce.com}sObject
     * java type: com.sforce.soap.enterprise.sobject.SObject
     */
    private static final com.sforce.ws.bind.TypeInfo Entity__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Entity","urn:sobject.enterprise.soap.sforce.com","sObject",0,1,true);

    private boolean Entity__is_set = false;

    private com.sforce.soap.enterprise.sobject.SObject Entity;

    public com.sforce.soap.enterprise.sobject.SObject getEntity() {
      return Entity;
    }

    public void setEntity(com.sforce.soap.enterprise.sobject.SObject Entity) {
      this.Entity = Entity;
      Entity__is_set = true;
    }

    /**
     * element : EntityCreatedBy of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo EntityCreatedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","EntityCreatedBy","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean EntityCreatedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.User EntityCreatedBy;

    public com.sforce.soap.enterprise.sobject.User getEntityCreatedBy() {
      return EntityCreatedBy;
    }

    public void setEntityCreatedBy(com.sforce.soap.enterprise.sobject.User EntityCreatedBy) {
      this.EntityCreatedBy = EntityCreatedBy;
      EntityCreatedBy__is_set = true;
    }

    /**
     * element : EntityCreatedById of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo EntityCreatedById__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","EntityCreatedById","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean EntityCreatedById__is_set = false;

    private java.lang.String EntityCreatedById;

    public java.lang.String getEntityCreatedById() {
      return EntityCreatedById;
    }

    public void setEntityCreatedById(java.lang.String EntityCreatedById) {
      this.EntityCreatedById = EntityCreatedById;
      EntityCreatedById__is_set = true;
    }

    /**
     * element : EntityId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo EntityId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","EntityId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean EntityId__is_set = false;

    private java.lang.String EntityId;

    public java.lang.String getEntityId() {
      return EntityId;
    }

    public void setEntityId(java.lang.String EntityId) {
      this.EntityId = EntityId;
      EntityId__is_set = true;
    }

    /**
     * element : EntityType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo EntityType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","EntityType","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean EntityType__is_set = false;

    private java.lang.String EntityType;

    public java.lang.String getEntityType() {
      return EntityType;
    }

    public void setEntityType(java.lang.String EntityType) {
      this.EntityType = EntityType;
      EntityType__is_set = true;
    }

    /**
     * element : IsDeleted of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: java.lang.Boolean
     */
    private static final com.sforce.ws.bind.TypeInfo IsDeleted__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","IsDeleted","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean IsDeleted__is_set = false;

    private java.lang.Boolean IsDeleted;

    public java.lang.Boolean getIsDeleted() {
      return IsDeleted;
    }

    public void setIsDeleted(java.lang.Boolean IsDeleted) {
      this.IsDeleted = IsDeleted;
      IsDeleted__is_set = true;
    }

    /**
     * element : LastModifiedBy of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedBy","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean LastModifiedBy__is_set = false;

    private com.sforce.soap.enterprise.sobject.User LastModifiedBy;

    public com.sforce.soap.enterprise.sobject.User getLastModifiedBy() {
      return LastModifiedBy;
    }

    public void setLastModifiedBy(com.sforce.soap.enterprise.sobject.User LastModifiedBy) {
      this.LastModifiedBy = LastModifiedBy;
      LastModifiedBy__is_set = true;
    }

    /**
     * element : LastModifiedById of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedById__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedById","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean LastModifiedById__is_set = false;

    private java.lang.String LastModifiedById;

    public java.lang.String getLastModifiedById() {
      return LastModifiedById;
    }

    public void setLastModifiedById(java.lang.String LastModifiedById) {
      this.LastModifiedById = LastModifiedById;
      LastModifiedById__is_set = true;
    }

    /**
     * element : LastModifiedDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo LastModifiedDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastModifiedDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean LastModifiedDate__is_set = false;

    private java.util.Calendar LastModifiedDate;

    public java.util.Calendar getLastModifiedDate() {
      return LastModifiedDate;
    }

    public void setLastModifiedDate(java.util.Calendar LastModifiedDate) {
      this.LastModifiedDate = LastModifiedDate;
      LastModifiedDate__is_set = true;
    }

    /**
     * element : Name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Name","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Name__is_set = false;

    private java.lang.String Name;

    public java.lang.String getName() {
      return Name;
    }

    public void setName(java.lang.String Name) {
      this.Name = Name;
      Name__is_set = true;
    }

    /**
     * element : Network of type {urn:sobject.enterprise.soap.sforce.com}Network
     * java type: com.sforce.soap.enterprise.sobject.Network
     */
    private static final com.sforce.ws.bind.TypeInfo Network__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Network","urn:sobject.enterprise.soap.sforce.com","Network",0,1,true);

    private boolean Network__is_set = false;

    private com.sforce.soap.enterprise.sobject.Network Network;

    public com.sforce.soap.enterprise.sobject.Network getNetwork() {
      return Network;
    }

    public void setNetwork(com.sforce.soap.enterprise.sobject.Network Network) {
      this.Network = Network;
      Network__is_set = true;
    }

    /**
     * element : NetworkId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo NetworkId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","NetworkId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean NetworkId__is_set = false;

    private java.lang.String NetworkId;

    public java.lang.String getNetworkId() {
      return NetworkId;
    }

    public void setNetworkId(java.lang.String NetworkId) {
      this.NetworkId = NetworkId;
      NetworkId__is_set = true;
    }

    /**
     * element : ParentEntity of type {urn:sobject.enterprise.soap.sforce.com}sObject
     * java type: com.sforce.soap.enterprise.sobject.SObject
     */
    private static final com.sforce.ws.bind.TypeInfo ParentEntity__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ParentEntity","urn:sobject.enterprise.soap.sforce.com","sObject",0,1,true);

    private boolean ParentEntity__is_set = false;

    private com.sforce.soap.enterprise.sobject.SObject ParentEntity;

    public com.sforce.soap.enterprise.sobject.SObject getParentEntity() {
      return ParentEntity;
    }

    public void setParentEntity(com.sforce.soap.enterprise.sobject.SObject ParentEntity) {
      this.ParentEntity = ParentEntity;
      ParentEntity__is_set = true;
    }

    /**
     * element : ParentEntityId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ParentEntityId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ParentEntityId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean ParentEntityId__is_set = false;

    private java.lang.String ParentEntityId;

    public java.lang.String getParentEntityId() {
      return ParentEntityId;
    }

    public void setParentEntityId(java.lang.String ParentEntityId) {
      this.ParentEntityId = ParentEntityId;
      ParentEntityId__is_set = true;
    }

    /**
     * element : ParentEntityType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ParentEntityType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ParentEntityType","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean ParentEntityType__is_set = false;

    private java.lang.String ParentEntityType;

    public java.lang.String getParentEntityType() {
      return ParentEntityType;
    }

    public void setParentEntityType(java.lang.String ParentEntityType) {
      this.ParentEntityType = ParentEntityType;
      ParentEntityType__is_set = true;
    }

    /**
     * element : SystemModstamp of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo SystemModstamp__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","SystemModstamp","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean SystemModstamp__is_set = false;

    private java.util.Calendar SystemModstamp;

    public java.util.Calendar getSystemModstamp() {
      return SystemModstamp;
    }

    public void setSystemModstamp(java.util.Calendar SystemModstamp) {
      this.SystemModstamp = SystemModstamp;
      SystemModstamp__is_set = true;
    }

    /**
     * element : UserRecordAccess of type {urn:sobject.enterprise.soap.sforce.com}UserRecordAccess
     * java type: com.sforce.soap.enterprise.sobject.UserRecordAccess
     */
    private static final com.sforce.ws.bind.TypeInfo UserRecordAccess__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","UserRecordAccess","urn:sobject.enterprise.soap.sforce.com","UserRecordAccess",0,1,true);

    private boolean UserRecordAccess__is_set = false;

    private com.sforce.soap.enterprise.sobject.UserRecordAccess UserRecordAccess;

    public com.sforce.soap.enterprise.sobject.UserRecordAccess getUserRecordAccess() {
      return UserRecordAccess;
    }

    public void setUserRecordAccess(com.sforce.soap.enterprise.sobject.UserRecordAccess UserRecordAccess) {
      this.UserRecordAccess = UserRecordAccess;
      UserRecordAccess__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "NetworkActivityAudit");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, Action__typeInfo, Action, Action__is_set);
       __typeMapper.writeObject(__out, CreatedBy__typeInfo, CreatedBy, CreatedBy__is_set);
       __typeMapper.writeString(__out, CreatedById__typeInfo, CreatedById, CreatedById__is_set);
       __typeMapper.writeObject(__out, CreatedDate__typeInfo, CreatedDate, CreatedDate__is_set);
       __typeMapper.writeString(__out, Description__typeInfo, Description, Description__is_set);
       __typeMapper.writeObject(__out, Entity__typeInfo, Entity, Entity__is_set);
       __typeMapper.writeObject(__out, EntityCreatedBy__typeInfo, EntityCreatedBy, EntityCreatedBy__is_set);
       __typeMapper.writeString(__out, EntityCreatedById__typeInfo, EntityCreatedById, EntityCreatedById__is_set);
       __typeMapper.writeString(__out, EntityId__typeInfo, EntityId, EntityId__is_set);
       __typeMapper.writeString(__out, EntityType__typeInfo, EntityType, EntityType__is_set);
       __typeMapper.writeObject(__out, IsDeleted__typeInfo, IsDeleted, IsDeleted__is_set);
       __typeMapper.writeObject(__out, LastModifiedBy__typeInfo, LastModifiedBy, LastModifiedBy__is_set);
       __typeMapper.writeString(__out, LastModifiedById__typeInfo, LastModifiedById, LastModifiedById__is_set);
       __typeMapper.writeObject(__out, LastModifiedDate__typeInfo, LastModifiedDate, LastModifiedDate__is_set);
       __typeMapper.writeString(__out, Name__typeInfo, Name, Name__is_set);
       __typeMapper.writeObject(__out, Network__typeInfo, Network, Network__is_set);
       __typeMapper.writeString(__out, NetworkId__typeInfo, NetworkId, NetworkId__is_set);
       __typeMapper.writeObject(__out, ParentEntity__typeInfo, ParentEntity, ParentEntity__is_set);
       __typeMapper.writeString(__out, ParentEntityId__typeInfo, ParentEntityId, ParentEntityId__is_set);
       __typeMapper.writeString(__out, ParentEntityType__typeInfo, ParentEntityType, ParentEntityType__is_set);
       __typeMapper.writeObject(__out, SystemModstamp__typeInfo, SystemModstamp, SystemModstamp__is_set);
       __typeMapper.writeObject(__out, UserRecordAccess__typeInfo, UserRecordAccess, UserRecordAccess__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.isElement(__in, Action__typeInfo)) {
            setAction(__typeMapper.readString(__in, Action__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedBy__typeInfo)) {
            setCreatedBy((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, CreatedBy__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedById__typeInfo)) {
            setCreatedById(__typeMapper.readString(__in, CreatedById__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CreatedDate__typeInfo)) {
            setCreatedDate((java.util.Calendar)__typeMapper.readObject(__in, CreatedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Description__typeInfo)) {
            setDescription(__typeMapper.readString(__in, Description__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Entity__typeInfo)) {
            setEntity((com.sforce.soap.enterprise.sobject.SObject)__typeMapper.readObject(__in, Entity__typeInfo, com.sforce.soap.enterprise.sobject.SObject.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, EntityCreatedBy__typeInfo)) {
            setEntityCreatedBy((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, EntityCreatedBy__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, EntityCreatedById__typeInfo)) {
            setEntityCreatedById(__typeMapper.readString(__in, EntityCreatedById__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, EntityId__typeInfo)) {
            setEntityId(__typeMapper.readString(__in, EntityId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, EntityType__typeInfo)) {
            setEntityType(__typeMapper.readString(__in, EntityType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, IsDeleted__typeInfo)) {
            setIsDeleted((java.lang.Boolean)__typeMapper.readObject(__in, IsDeleted__typeInfo, java.lang.Boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedBy__typeInfo)) {
            setLastModifiedBy((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, LastModifiedBy__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedById__typeInfo)) {
            setLastModifiedById(__typeMapper.readString(__in, LastModifiedById__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, LastModifiedDate__typeInfo)) {
            setLastModifiedDate((java.util.Calendar)__typeMapper.readObject(__in, LastModifiedDate__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Name__typeInfo)) {
            setName(__typeMapper.readString(__in, Name__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Network__typeInfo)) {
            setNetwork((com.sforce.soap.enterprise.sobject.Network)__typeMapper.readObject(__in, Network__typeInfo, com.sforce.soap.enterprise.sobject.Network.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, NetworkId__typeInfo)) {
            setNetworkId(__typeMapper.readString(__in, NetworkId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ParentEntity__typeInfo)) {
            setParentEntity((com.sforce.soap.enterprise.sobject.SObject)__typeMapper.readObject(__in, ParentEntity__typeInfo, com.sforce.soap.enterprise.sobject.SObject.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ParentEntityId__typeInfo)) {
            setParentEntityId(__typeMapper.readString(__in, ParentEntityId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ParentEntityType__typeInfo)) {
            setParentEntityType(__typeMapper.readString(__in, ParentEntityType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, SystemModstamp__typeInfo)) {
            setSystemModstamp((java.util.Calendar)__typeMapper.readObject(__in, SystemModstamp__typeInfo, java.util.Calendar.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, UserRecordAccess__typeInfo)) {
            setUserRecordAccess((com.sforce.soap.enterprise.sobject.UserRecordAccess)__typeMapper.readObject(__in, UserRecordAccess__typeInfo, com.sforce.soap.enterprise.sobject.UserRecordAccess.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[NetworkActivityAudit ");
      sb.append(super.toString());sb.append(" Action='").append(com.sforce.ws.util.Verbose.toString(Action)).append("'\n");
      sb.append(" CreatedBy='").append(com.sforce.ws.util.Verbose.toString(CreatedBy)).append("'\n");
      sb.append(" CreatedById='").append(com.sforce.ws.util.Verbose.toString(CreatedById)).append("'\n");
      sb.append(" CreatedDate='").append(com.sforce.ws.util.Verbose.toString(CreatedDate)).append("'\n");
      sb.append(" Description='").append(com.sforce.ws.util.Verbose.toString(Description)).append("'\n");
      sb.append(" Entity='").append(com.sforce.ws.util.Verbose.toString(Entity)).append("'\n");
      sb.append(" EntityCreatedBy='").append(com.sforce.ws.util.Verbose.toString(EntityCreatedBy)).append("'\n");
      sb.append(" EntityCreatedById='").append(com.sforce.ws.util.Verbose.toString(EntityCreatedById)).append("'\n");
      sb.append(" EntityId='").append(com.sforce.ws.util.Verbose.toString(EntityId)).append("'\n");
      sb.append(" EntityType='").append(com.sforce.ws.util.Verbose.toString(EntityType)).append("'\n");
      sb.append(" IsDeleted='").append(com.sforce.ws.util.Verbose.toString(IsDeleted)).append("'\n");
      sb.append(" LastModifiedBy='").append(com.sforce.ws.util.Verbose.toString(LastModifiedBy)).append("'\n");
      sb.append(" LastModifiedById='").append(com.sforce.ws.util.Verbose.toString(LastModifiedById)).append("'\n");
      sb.append(" LastModifiedDate='").append(com.sforce.ws.util.Verbose.toString(LastModifiedDate)).append("'\n");
      sb.append(" Name='").append(com.sforce.ws.util.Verbose.toString(Name)).append("'\n");
      sb.append(" Network='").append(com.sforce.ws.util.Verbose.toString(Network)).append("'\n");
      sb.append(" NetworkId='").append(com.sforce.ws.util.Verbose.toString(NetworkId)).append("'\n");
      sb.append(" ParentEntity='").append(com.sforce.ws.util.Verbose.toString(ParentEntity)).append("'\n");
      sb.append(" ParentEntityId='").append(com.sforce.ws.util.Verbose.toString(ParentEntityId)).append("'\n");
      sb.append(" ParentEntityType='").append(com.sforce.ws.util.Verbose.toString(ParentEntityType)).append("'\n");
      sb.append(" SystemModstamp='").append(com.sforce.ws.util.Verbose.toString(SystemModstamp)).append("'\n");
      sb.append(" UserRecordAccess='").append(com.sforce.ws.util.Verbose.toString(UserRecordAccess)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
