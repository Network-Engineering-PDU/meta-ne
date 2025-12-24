# -*- mode: Conf; -*-
DESCRIPTION = "Tychetools Image for heimdall. \
This image contains everything used to run a gateway."
LICENSE = "CLOSED"

inherit core-image features_check
inherit extrausers

IMAGE_FEATURES += " \
    package-management \
    ssh-server-openssh \
    debug-tweaks \
    tools-debug \
"

IMAGE_FEATURES += "read-only-rootfs"

# TODO create packagegroup with devtools

CORE_IMAGE_EXTRA_INSTALL += " \
	packagegroup-core-full-cmdline \
	packagegroup-tools-bluetooth \
	packagegroup-core-buildessential \
	screen \
	tmux \
	vim \
	minicom \
	git \
	rpm \
	chrony \
	chronyc \
	curl \
	curl-dev \
	cjson \
	cjson-dev \
	haveged \
	tcpdump \
	i2c-tools \
	cmake \
	python3-setuptools \
	python3-smbus2 \
	python3-pip \
	watchdog \
	tzdata \
	sqlite3 \
	libsqlite3 \
	python3-spidev \
	python3-numpy \
	python3-pillow \
	python3-smbus \
	python3-influxdb-client \
	python3-psutil \
	python3-ruamel-yaml \
	python3-ruamel-yaml-clib \
	python3-drf-yasg \
	python3-inflection \
	networkmanager \
	modemmanager \
	ttautossh \
	ttsetup \
	socat \
	ufw \
	bash-completion \
	mosquitto \
	python3-paho-mqtt \
	nmap \
	libgpiod \
	libgpiod-dev \
	libgpiod-tools \
	libmodbus \
	libmodbus-dev \
	nfs-utils \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttgateway', 'python3-ttgateway', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttgatewayfw', 'gw-firmware', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttble', 'python3-ttbleserver', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttsnmp', 'ttsnmp', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttsnmp', 'net-snmp-server-snmpd', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttmodbus', 'ttmodbus', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'tslib', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'fbida', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'freetype', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'cmdisplay', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'evtest', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'cmdisplay', 'usbautomount', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'tt4g', 'ppp', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'tt4g', 'usb-modeswitch', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'tt4g', 'resolvconf', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'gpiomodule', 'gpiomodule', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'gpiomodule', 'libgpiod', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'gpiomodule', 'libgpiod-dev', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'usbautorun', 'usbautorun', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'ttdiagnosis', 'python3-ttdiagnosis', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'necm', 'python3-ttne', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'necm', 'python3-ne', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'necm', 'nginx', '', d)} \
"

systemd_disable_vt () {
    rm ${IMAGE_ROOTFS}${sysconfdir}/systemd/system/getty.target.wants/getty@tty*.service
}

IMAGE_PREPROCESS_COMMAND_append = " ${@ 'systemd_disable_vt;' if bb.utils.contains('DISTRO_FEATURES', 'systemd', True, False, d) and bb.utils.contains('USE_VT', '0', True, False, d) else ''} "

EXTRA_USERS_PARAMS = " \
	useradd ${LINUX_USER}; \
	usermod -aG dialout ${LINUX_USER}; \
	usermod  -P ${LINUX_PASS} ${LINUX_USER}; \
	usermod  -P ${LINUX_PASS} root; \
"
