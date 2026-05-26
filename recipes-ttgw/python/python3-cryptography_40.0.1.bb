SUMMARY = "Provides cryptographic recipes and primitives"
DESCRIPTION = "cryptography is a package which provides cryptographic recipes and primitives to Python developers."
HOMEPAGE = "https://github.com/pyca/cryptography"
LICENSE = "Apache-2.0 | BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8c7abffc8fbedfa67638ba3fe924b6ca"

SRC_URI = "https://files.pythonhosted.org/packages/source/c/cryptography/cryptography-40.0.1.tar.gz"
SRC_URI[sha256sum] = "541adb322b59b8b4b51faf82d0751dc6eb96f0d5e1ad0c9eef4b0e7f6c6c2a82"

DEPENDS = "openssl libffi python3-native python3-cffi-native"
RDEPENDS:${PN} = "openssl python3-cffi libffi"

S = "${WORKDIR}/cryptography-40.0.1"

inherit setuptools3

BBCLASSEXTEND = "native nativesdk"
PROVIDES += "python3-cryptography"

# Ensure OpenSSL headers are available for cffi to generate complete bindings
export LDFLAGS = "-L${STAGING_LIBDIR}"
export CFLAGS = "-I${STAGING_INCDIR}"
export CPPFLAGS = "-I${STAGING_INCDIR}"
export PKG_CONFIG_PATH = "${STAGING_LIBDIR}/pkgconfig"

FILES:${PN} += "\
	${libdir}/${PYTHON_DIR}/site-packages/* \
"
