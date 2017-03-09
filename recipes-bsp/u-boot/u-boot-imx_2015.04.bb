# Copyright (C) 2013, 2014 Freescale Semiconductor

DESCRIPTION = "Bootloader for i.MX platforms"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "imx_v2015.04_4.1.15_1.0.0_ga"
SRCREV = "d7d7c4312b71dd3879fa8640b23f6a5bac30e303"
UBOOT_SRC ?= "git://git.denx.de/u-boot-imx.git;protocol=git"
#SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRC_URI = "http://git.freescale.com/git/cgit.cgi/imx/uboot-imx.git/snapshot/rel_imx_4.1.15_1.0.0_ga.tar.bz2"
SRC_URI[md5sum] = "15f9ed70c501d63383e94c5dac37ed8b"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PR="r7"
LOCALVERSION = "-${PR}"

S = "${WORKDIR}/rel_imx_4.1.15_1.0.0_ga"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

SRC_URI += "file://0001-score-Add-board-score.patch"
SRC_URI += "file://0002-arch-arm-Kconfig-Add-score-board-to-arm-configuratio.patch"
SRC_URI += "file://0003-board-score-Add-methode-for-getting-the-cs-of-spi.patch"
SRC_URI += "file://0004-config-score_defconfig-Add-option-for-SPINOR.patch"
SRC_URI += "file://0005-include-configs-score-Cleaning-Up.patch"
SRC_URI += "file://0006-tools-env-env_flags-Add-ARRAY_SIZE-macro.patch"
SRC_URI += "file://0007-board-score-Add-init-avail.-SD-interface.patch"
SRC_URI += "file://0008-configs-score-Add-update_nor-from-sd2.patch"
SRC_URI += "file://0009-configs-score-Add-command-to-boot-from-sd2-and-sd3.patch"
SRC_URI += "file://0010-configs-score-Rename-update_nor-command.patch"
SRC_URI += "file://0011-configs-score-Change-filenames-for-dtbs.patch"
SRC_URI += "file://0012-configs-score-Correct-name-for-eval-board-dtb-file.patch"
SRC_URI += "file://0013-configs-score-Add-environment-for-mfgboot.patch"
SRC_URI += "file://0014-configs-score-Add-configuration-for-pca953x-port-exp.patch"
SRC_URI += "file://0015-board-score-Add-intit-for-pca953x.patch"
SRC_URI += "file://0016-configs-score-Change-bootcmd-for-mfg-boot.patch"
SRC_URI += "file://0017-configs-mx6_common-Define-CONFIG_SYS_BOOTM_LEN.patch"
SRC_URI += "file://0018-board-score-Add-i2cbus-2-and-remove-unused.patch"
SRC_URI += "file://0019-configs-score-Add-scripts-for-mfg-boot.patch"
