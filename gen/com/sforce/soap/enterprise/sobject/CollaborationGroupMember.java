package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class CollaborationGroupMember extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public CollaborationGroupMember() {}

    /**
     * element : CollaborationGroup of type {urn:sobject.enterprise.soap.sforce.com}CollaborationGroup
     * java type: com.sforce.soap.enterprise.sobject.CollaborationGroup
     */
    private static final com.sforce.ws.bind.TypeInfo CollaborationGroup__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CollaborationGroup","urn:sobject.enterprise.soap.sforce.com","CollaborationGroup",0,1,true);

    private boolean CollaborationGroup__is_set = false;

    private com.sforce.soap.enterprise.sobject.CollaborationGroup CollaborationGroup;

    public com.sforce.soap.enterprise.sobject.CollaborationGroup getCollaborationGroup() {
      return CollaborationGroup;
    }

    public void setCollaborationGroup(com.sforce.soap.enterprise.sobject.CollaborationGroup CollaborationGroup) {
      this.CollaborationGroup = CollaborationGroup;
      CollaborationGroup__is_set = true;
    }

    /**
     * element : CollaborationGroupId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo CollaborationGroupId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CollaborationGroupId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean CollaborationGroupId__is_set = false;

    private java.lang.String CollaborationGroupId;

    public java.lang.String getCollaborationGroupId() {
      return CollaborationGroupId;
    }

    public void setCollaborationGroupId(java.lang.String CollaborationGroupId) {
      this.CollaborationGroupId = CollaborationGroupId;
      CollaborationGroupId__is_set = true;
    }

    /**
     * element : CollaborationRole of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo CollaborationRole__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","CollaborationRole","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean CollaborationRole__is_set = false;

    private java.lang.String CollaborationRole;

    public java.lang.String getCollaborationRole() {
      return CollaborationRole;
    }

    public void setCollaborationRole(java.lang.String CollaborationRole) {
      this.CollaborationRole = CollaborationRole;
      CollaborationRole__is_set = true;
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
     * element : LastFeedAccessDate of type {http://www.w3.org/2001/XMLSchema}dateTime
     * java type: java.util.Calendar
     */
    private static final com.sforce.ws.bind.TypeInfo LastFeedAccessDate__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","LastFeedAccessDate","http://www.w3.org/2001/XMLSchema","dateTime",0,1,true);

    private boolean LastFeedAccessDate__is_set = false;

    private java.util.Calendar LastFeedAccessDate;

    public java.util.Calendar getLastFeedAccessDate() {
      return LastFeedAccessDate;
    }

    public void setLastFeedAccessDate(java.util.Calendar LastFeedAccessDate) {
      this.LastFeedAccessDate = LastFeedAccessDate;
      LastFeedAccessDate__is_set = true;
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
     * element : Member of type {urn:sobject.enterprise.soap.sforce.com}User
     * java type: com.sforce.soap.enterprise.sobject.User
     */
    private static final com.sforce.ws.bind.TypeInfo Member__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Member","urn:sobject.enterprise.soap.sforce.com","User",0,1,true);

    private boolean Member__is_set = false;

    private com.sforce.soap.enterprise.sobject.User Member;

    public com.sforce.soap.enterprise.sobject.User getMember() {
      return Member;
    }

    public void setMember(com.sforce.soap.enterprise.sobject.User Member) {
      this.Member = Member;
      Member__is_set = true;
    }

    /**
     * element : MemberId of type {urn:enterprise.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo MemberId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","MemberId","urn:enterprise.soap.sforce.com","ID",0,1,true);

    private boolean MemberId__is_set = false;

    private java.lang.String MemberId;

    public java.lang.String getMemberId() {
      return MemberId;
    }

    public void setMemberId(java.lang.String MemberId) {
      this.MemberId = MemberId;
      MemberId__is_set = true;
    }

    /**
     * element : NotificationFrequency of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo NotificationFrequency__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","NotificationFrequency","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean NotificationFrequency__is_set = false;

    private java.lang.String NotificationFrequency;

    public java.lang.String getNotificationFrequency() {
      return NotificationFrequency;
    }

    public void setNotificationFrequency(java.lang.String NotificationFrequency) {
      this.NotificationFrequency = NotificationFrequency;
      NotificationFrequency__is_set = true;
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
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "CollaborationGroupMember");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeObject(__out, CollaborationGroup__typeInfo, CollaborationGroup, CollaborationGroup__is_set);
       __typeMapper.writeString(__out, CollaborationGroupId__typeInfo, CollaborationGroupId, CollaborationGroupId__is_set);
       __typeMapper.writeString(__out, CollaborationRole__typeInfo, CollaborationRole, CollaborationRole__is_set);
       __typeMapper.writeObject(__out, CreatedBy__typeInfo, CreatedBy, CreatedBy__is_set);
       __typeMapper.writeString(__out, CreatedById__typeInfo, CreatedById, CreatedById__is_set);
       __typeMapper.writeObject(__out, CreatedDate__typeInfo, CreatedDate, CreatedDate__is_set);
       __typeMapper.writeObject(__out, LastFeedAccessDate__typeInfo, LastFeedAccessDate, LastFeedAccessDate__is_set);
       __typeMapper.writeObject(__out, LastModifiedBy__typeInfo, LastModifiedBy, LastModifiedBy__is_set);
       __typeMapper.writeString(__out, LastModifiedById__typeInfo, LastModifiedById, LastModifiedById__is_set);
       __typeMapper.writeObject(__out, LastModifiedDate__typeInfo, LastModifiedDate, LastModifiedDate__is_set);
       __typeMapper.writeObject(__out, Member__typeInfo, Member, Member__is_set);
       __typeMapper.writeString(__out, MemberId__typeInfo, MemberId, MemberId__is_set);
       __typeMapper.writeString(__out, NotificationFrequency__typeInfo, NotificationFrequency, NotificationFrequency__is_set);
       __typeMapper.writeObject(__out, SystemModstamp__typeInfo, SystemModstamp, SystemModstamp__is_set);
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
        if (__typeMapper.isElement(__in, CollaborationGroup__typeInfo)) {
            setCollaborationGroup((com.sforce.soap.enterprise.sobject.CollaborationGroup)__typeMapper.readObject(__in, CollaborationGroup__typeInfo, com.sforce.soap.enterprise.sobject.CollaborationGroup.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CollaborationGroupId__typeInfo)) {
            setCollaborationGroupId(__typeMapper.readString(__in, CollaborationGroupId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, CollaborationRole__typeInfo)) {
            setCollaborationRole(__typeMapper.readString(__in, CollaborationRole__typeInfo, java.lang.String.class));
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
        if (__typeMapper.isElement(__in, LastFeedAccessDate__typeInfo)) {
            setLastFeedAccessDate((java.util.Calendar)__typeMapper.readObject(__in, LastFeedAccessDate__typeInfo, java.util.Calendar.class));
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
        if (__typeMapper.isElement(__in, Member__typeInfo)) {
            setMember((com.sforce.soap.enterprise.sobject.User)__typeMapper.readObject(__in, Member__typeInfo, com.sforce.soap.enterprise.sobject.User.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, MemberId__typeInfo)) {
            setMemberId(__typeMapper.readString(__in, MemberId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, NotificationFrequency__typeInfo)) {
            setNotificationFrequency(__typeMapper.readString(__in, NotificationFrequency__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, SystemModstamp__typeInfo)) {
            setSystemModstamp((java.util.Calendar)__typeMapper.readObject(__in, SystemModstamp__typeInfo, java.util.Calendar.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[CollaborationGroupMember ");
      sb.append(super.toString());sb.append(" CollaborationGroup='").append(com.sforce.ws.util.Verbose.toString(CollaborationGroup)).append("'\n");
      sb.append(" CollaborationGroupId='").append(com.sforce.ws.util.Verbose.toString(CollaborationGroupId)).append("'\n");
      sb.append(" CollaborationRole='").append(com.sforce.ws.util.Verbose.toString(CollaborationRole)).append("'\n");
      sb.append(" CreatedBy='").append(com.sforce.ws.util.Verbose.toString(CreatedBy)).append("'\n");
      sb.append(" CreatedById='").append(com.sforce.ws.util.Verbose.toString(CreatedById)).append("'\n");
      sb.append(" CreatedDate='").append(com.sforce.ws.util.Verbose.toString(CreatedDate)).append("'\n");
      sb.append(" LastFeedAccessDate='").append(com.sforce.ws.util.Verbose.toString(LastFeedAccessDate)).append("'\n");
      sb.append(" LastModifiedBy='").append(com.sforce.ws.util.Verbose.toString(LastModifiedBy)).append("'\n");
      sb.append(" LastModifiedById='").append(com.sforce.ws.util.Verbose.toString(LastModifiedById)).append("'\n");
      sb.append(" LastModifiedDate='").append(com.sforce.ws.util.Verbose.toString(LastModifiedDate)).append("'\n");
      sb.append(" Member='").append(com.sforce.ws.util.Verbose.toString(Member)).append("'\n");
      sb.append(" MemberId='").append(com.sforce.ws.util.Verbose.toString(MemberId)).append("'\n");
      sb.append(" NotificationFrequency='").append(com.sforce.ws.util.Verbose.toString(NotificationFrequency)).append("'\n");
      sb.append(" SystemModstamp='").append(com.sforce.ws.util.Verbose.toString(SystemModstamp)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
