#FROM daggerok/jboss-eap-6.4:6.4.22-alpine
##COPY --chown=jboss ./module-ear/target/*.war ${JBOSS_HOME}/standalone/deployments/
#RUN sudo chown -R jboss:jboss ${JBOSS_HOME}/standalone/deployments/
##ENV JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
##HEALTHCHECK --retries=3 \
##             --timeout=1s \
##             --interval=1s \
##             CMD wget -q --spider http://127.0.0.1:8080/web/rest/members || exit 1
#EXPOSE 5005
FROM mrbueno22/custom-jboss-eap-64:2
#COPY ./module-ear-1.0-SNAPSHOT.ear ${JBOSS_HOME}/standalone/deployments/module-ear-1.0-SNAPSHOT.ear
COPY ./module-ear/target/module-ear-1.0-SNAPSHOT.ear ${JBOSS_HOME}/standalone/deployments/module-ear-1.0-SNAPSHOT.ear
RUN sudo chown -R jboss:jboss ${JBOSS_HOME}/standalone/deployments/
EXPOSE 5005
EXPOSE 9999
EXPOSE 8080
EXPOSE 8443
EXPOSE 9990
