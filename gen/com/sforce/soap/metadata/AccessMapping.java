package com.sforce.soap.metadata;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class AccessMapping implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public AccessMapping() {}

    /**
     * element : accessLevel of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo accessLevel__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","accessLevel","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean accessLevel__is_set = false;

    private java.lang.String accessLevel;

    public java.lang.String getAccessLevel() {
      return accessLevel;
    }

    public void setAccessLevel(java.lang.String accessLevel) {
      this.accessLevel = accessLevel;
      accessLevel__is_set = true;
    }

    /**
     * element : object of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo object__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","object","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean object__is_set = false;

    private java.lang.String object;

    public java.lang.String getObject() {
      return object;
    }

    public void setObject(java.lang.String object) {
      this.object = object;
      object__is_set = true;
    }

    /**
     * element : objectField of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo objectField__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","objectField","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean objectField__is_set = false;

    private java.lang.String objectField;

    public java.lang.String getObjectField() {
      return objectField;
    }

    public void setObjectField(java.lang.String objectField) {
      this.objectField = objectField;
      objectField__is_set = true;
    }

    /**
     * element : userField of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo userField__typeInfo =
      new com.sforce.ws.bind.TypeInfo("http://soap.sforce.com/2006/04/metadata","userField","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean userField__is_set = false;

    private java.lang.String userField;

    public java.lang.String getUserField() {
      return userField;
    }

    public void setUserField(java.lang.String userField) {
      this.userField = userField;
      userField__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeString(__out, accessLevel__typeInfo, accessLevel, accessLevel__is_set);
       __typeMapper.writeString(__out, object__typeInfo, object, object__is_set);
       __typeMapper.writeString(__out, objectField__typeInfo, objectField, objectField__is_set);
       __typeMapper.writeString(__out, userField__typeInfo, userField, userField__is_set);
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
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, accessLevel__typeInfo)) {
            setAccessLevel(__typeMapper.readString(__in, accessLevel__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, object__typeInfo)) {
            setObject(__typeMapper.readString(__in, object__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, objectField__typeInfo)) {
            setObjectField(__typeMapper.readString(__in, objectField__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, userField__typeInfo)) {
            setUserField(__typeMapper.readString(__in, userField__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[AccessMapping ");
      sb.append(" accessLevel='").append(com.sforce.ws.util.Verbose.toString(accessLevel)).append("'\n");
      sb.append(" object='").append(com.sforce.ws.util.Verbose.toString(object)).append("'\n");
      sb.append(" objectField='").append(com.sforce.ws.util.Verbose.toString(objectField)).append("'\n");
      sb.append(" userField='").append(com.sforce.ws.util.Verbose.toString(userField)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}