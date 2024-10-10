import request from '@/utils/request'

// 查询生产机构列表
export function listOrganization(query) {
  return request({
    url: '/commondata/organization/list',
    method: 'get',
    params: query
  })
}

// 查询生产机构详细
export function getOrganization(id) {
  return request({
    url: '/commondata/organization/' + id,
    method: 'get'
  })
}

// 新增生产机构
export function addOrganization(data) {
  return request({
    url: '/commondata/organization',
    method: 'post',
    data: data
  })
}

// 修改生产机构
export function updateOrganization(data) {
  return request({
    url: '/commondata/organization',
    method: 'put',
    data: data
  })
}

// 删除生产机构
export function delOrganization(id) {
  return request({
    url: '/commondata/organization/' + id,
    method: 'delete'
  })
}
