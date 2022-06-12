/*
 * @Author: chad 2319315514@qq.com
 * @Date: 2022-06-12 11:24:58
 * @LastEditors: chad 2319315514@qq.com
 * @LastEditTime: 2022-06-12 11:27:42
 * @FilePath: \foelep-ui\src\api\flowable\finished.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/utils/request'
import da from "element-ui/src/locale/lang/da";

// 查询已办任务列表
export function finishedList(query) {
  return request({
    url: '/system/flowable/task/finishedList',
    method: 'get',
    params: query
  })
}

// 任务流转记录
export function flowRecord(query) {
  return request({
    url: '/system/flowable/task/flowRecord',
    method: 'get',
    params: query
  })
}

// 撤回任务
export function revokeProcess(data) {
  return request({
    url: '/system/flowable/task/revokeProcess',
    method: 'post',
    data: data
  })
}

// 部署流程实例
export function deployStart(deployId) {
  return request({
    url: '/system/flowable/process/startFlow/' + deployId,
    method: 'get',
  })
}

// 查询流程定义详细
export function getDeployment(id) {
  return request({
    url: '/system/deployment/' + id,
    method: 'get'
  })
}

// 新增流程定义
export function addDeployment(data) {
  return request({
    url: '/system/deployment',
    method: 'post',
    data: data
  })
}

// 修改流程定义
export function updateDeployment(data) {
  return request({
    url: '/system/deployment',
    method: 'put',
    data: data
  })
}

// 删除流程定义
export function delDeployment(id) {
  return request({
    url: '/system/flowable/instance/delete/?instanceId=' + id,
    method: 'delete'
  })
}

// 导出流程定义
export function exportDeployment(query) {
  return request({
    url: '/system/deployment/export',
    method: 'get',
    params: query
  })
}
