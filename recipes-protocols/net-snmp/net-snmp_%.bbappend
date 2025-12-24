# -*- mode: Conf; -*-
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
INITSCRIPT_PARAMS_${PN}-server-snmpd = "stop 60 0 1 6 ."

EXTRA_OECONF:remove = "--with-mib-modules=smux"

EXTRA_OECONF += "--with-out-mib-modules=snmpv3mib,mibII/vacmcd_snmp,notification,notification-log-mib,target,agent_mibs,agentx,disman/event,disman/schedule,host"

DEPENDS:remove = "pciutils"

RDEPENDS_${PN}-libs:remove= "libpci"
