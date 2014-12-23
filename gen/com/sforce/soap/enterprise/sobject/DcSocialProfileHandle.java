package com.sforce.soap.enterprise.sobject;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DcSocialProfileHandle extends com.sforce.soap.enterprise.sobject.SObject {

    /**
     * Constructor
     */
    public DcSocialProfileHandle() {}

    /**
     * element : DcSocialProfile of type {urn:sobject.enterprise.soap.sforce.com}DcSocialProfile
     * java type: com.sforce.soap.enterprise.sobject.DcSocialProfile
     */
    private static final com.sforce.ws.bind.TypeInfo DcSocialProfile__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","DcSocialProfile","urn:sobject.enterprise.soap.sforce.com","DcSocialProfile",0,1,true);

    private boolean DcSocialProfile__is_set = false;

    private com.sforce.soap.enterprise.sobject.DcSocialProfile DcSocialProfile;

    public com.sforce.soap.enterprise.sobject.DcSocialProfile getDcSocialProfile() {
      return DcSocialProfile;
    }

    public void setDcSocialProfile(com.sforce.soap.enterprise.sobject.DcSocialProfile DcSocialProfile) {
      this.DcSocialProfile = DcSocialProfile;
      DcSocialProfile__is_set = true;
    }

    /**
     * element : DcSocialProfileId of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo DcSocialProfileId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","DcSocialProfileId","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean DcSocialProfileId__is_set = false;

    private java.lang.String DcSocialProfileId;

    public java.lang.String getDcSocialProfileId() {
      return DcSocialProfileId;
    }

    public void setDcSocialProfileId(java.lang.String DcSocialProfileId) {
      this.DcSocialProfileId = DcSocialProfileId;
      DcSocialProfileId__is_set = true;
    }

    /**
     * element : ExternalId of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ExternalId__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ExternalId","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean ExternalId__is_set = false;

    private java.lang.String ExternalId;

    public java.lang.String getExternalId() {
      return ExternalId;
    }

    public void setExternalId(java.lang.String ExternalId) {
      this.ExternalId = ExternalId;
      ExternalId__is_set = true;
    }

    /**
     * element : Handle of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo Handle__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","Handle","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean Handle__is_set = false;

    private java.lang.String Handle;

    public java.lang.String getHandle() {
      return Handle;
    }

    public void setHandle(java.lang.String Handle) {
      this.Handle = Handle;
      Handle__is_set = true;
    }

    /**
     * element : ProviderName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo ProviderName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:sobject.enterprise.soap.sforce.com","ProviderName","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean ProviderName__is_set = false;

    private java.lang.String ProviderName;

    public java.lang.String getProviderName() {
      return ProviderName;
    }

    public void setProviderName(java.lang.String ProviderName) {
      this.ProviderName = ProviderName;
      ProviderName__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:sobject.enterprise.soap.sforce.com", "DcSocialProfileHandle");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeObject(__out, DcSocialProfile__typeInfo, DcSocialProfile, DcSocialProfile__is_set);
       __typeMapper.writeString(__out, DcSocialProfileId__typeInfo, DcSocialProfileId, DcSocialProfileId__is_set);
       __typeMapper.writeString(__out, ExternalId__typeInfo, ExternalId, ExternalId__is_set);
       __typeMapper.writeString(__out, Handle__typeInfo, Handle, Handle__is_set);
       __typeMapper.writeString(__out, ProviderName__typeInfo, ProviderName, ProviderName__is_set);
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
        if (__typeMapper.isElement(__in, DcSocialProfile__typeInfo)) {
            setDcSocialProfile((com.sforce.soap.enterprise.sobject.DcSocialProfile)__typeMapper.readObject(__in, DcSocialProfile__typeInfo, com.sforce.soap.enterprise.sobject.DcSocialProfile.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, DcSocialProfileId__typeInfo)) {
            setDcSocialProfileId(__typeMapper.readString(__in, DcSocialProfileId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ExternalId__typeInfo)) {
            setExternalId(__typeMapper.readString(__in, ExternalId__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, Handle__typeInfo)) {
            setHandle(__typeMapper.readString(__in, Handle__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, ProviderName__typeInfo)) {
            setProviderName(__typeMapper.readString(__in, ProviderName__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DcSocialProfileHandle ");
      sb.append(super.toString());sb.append(" DcSocialProfile='").append(com.sforce.ws.util.Verbose.toString(DcSocialProfile)).append("'\n");
      sb.append(" DcSocialProfileId='").append(com.sforce.ws.util.Verbose.toString(DcSocialProfileId)).append("'\n");
      sb.append(" ExternalId='").append(com.sforce.ws.util.Verbose.toString(ExternalId)).append("'\n");
      sb.append(" Handle='").append(com.sforce.ws.util.Verbose.toString(Handle)).append("'\n");
      sb.append(" ProviderName='").append(com.sforce.ws.util.Verbose.toString(ProviderName)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
